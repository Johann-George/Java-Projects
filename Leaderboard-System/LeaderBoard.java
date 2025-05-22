import java.util.ArrayList;
import java.util.SortedMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;
import java.util.List;
import java.util.Comparator;
import lib.LeaderBoardValidator;

class LeaderBoard {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    // custom comparator to sort elements in descending order
    SortedMap<Integer, List<String>> map = new TreeMap<Integer, List<String>>(new Comparator<Integer>() {
      public int compare(Integer a, Integer b) {
        return b.compareTo(a);
      }
    });
    System.out.println("Enter the number of players:");
    int no = LeaderBoardValidator.integerValidator(sc);
    for (int i = 0; i < no; i++) {
      sc.nextLine();
      System.out.println("Enter the name of the player:");
      String name = sc.nextLine();
      System.out.println(" Enter the score:");
      int score = LeaderBoardValidator.integerValidator(sc);
      map.putIfAbsent(score, new ArrayList<>());
      map.get(score).add(name);
    }
    // Displaying the treemap
    System.out.println("The leaderboard:");
    for (Map.Entry<Integer, List<String>> e : map.entrySet()) {
      System.out.println("Score:" + e.getKey() + " Players: " + e.getValue());
    }
    sc.close();

  }

}
