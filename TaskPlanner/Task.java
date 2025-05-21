import lib.TaskValidator;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Deque;
import java.util.Scanner;

class Task {

  public static void main(String[] args) {

    // Enter the tasks in order
    Scanner sc = new Scanner(System.in);
    Deque<String> queue = new LinkedList<>();
    Stack<String> undoStack = new Stack<>();
    Stack<String> redoStack = new Stack<>();
    int cont = 1;
    while (cont != 0) {
      System.out.println("1.Add a task\n2.Remove a task\n3.Display the tasks\n4.Undo operation\n5.Redo operation");
      System.out.println("Enter the operation you want to perform :");
      int no = TaskValidator.integerValidator(sc);
      sc.nextLine();
      // Add a task
      if (no == 1) {
        System.out.println("Enter the task:");
        String task = sc.nextLine();
        queue.add(task);
        undoStack.push("Remove:" + task);
        // Remove a task
      } else if (no == 2) {
        if (queue.isEmpty()) {
          System.out.println("No tasks pending to be removed");
          continue;
        }
        undoStack.push("Add:" + queue.poll());
        System.out.println("Task successfully removed");
        // Display the tasks
      } else if (no == 3) {
        Iterator<String> iterator = queue.iterator();
        while (iterator.hasNext()) {
          System.out.println(iterator.next());
        }
      } else if (no == 4) {
        if (undoStack.empty()) {
          System.out.println("No undo operation performed!");
          continue;
        }
        String[] operation = undoStack.pop().split(":", 2);
        String action = operation[0];
        String task = operation[1];
        if (action.equals("Remove")) {
          queue.remove(task);
          redoStack.push("Add:" + task);
        } else {
          queue.addFirst(task);
          redoStack.push("Remove:" + task);
        }
        System.out.println("Undo operation performed!");
      } else if (no == 5) {
        if (redoStack.empty()) {
          System.out.println("No redo operation performed!");
          continue;
        }
        String[] redoOperation = redoStack.pop().split(":", 2);
        String action = redoOperation[0];
        String task = redoOperation[1];
        if (action.equals("Add")) {
          queue.addFirst(task);
          undoStack.push("Remove:" + task);
        } else {
          queue.remove(task);
          undoStack.push("Add:" + task);
        }
        System.out.println("Redo operation performed!");
      } else {
        System.out.println("Enter a valid input");
      }

    }

  }

}
