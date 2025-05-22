import java.util.Collections;
import java.util.TreeSet;

class Visitor {

  public static void main(String[] args) {

    String[] visitors = { "Alice", "Bob", "alice", "Charlie", "bob", "David", "charlie" };
    TreeSet<String> set = new TreeSet<>();
    // adding all the names to the tree set
    for (int i = 0; i < visitors.length; i++) {
      set.add(visitors[i].toLowerCase());
    }
    // displaying the names in sorted order
    System.out.println("The unique names of visitors are:");
    for (String name : set) {
      System.out.println(name);
    }

  }

}
