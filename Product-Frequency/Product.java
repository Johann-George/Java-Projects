import java.util.ArrayList;
import java.util.Map;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;

class Product {

  public static void main(String[] args) {

    List<String> products = Arrays.asList(
        "Laptop", "Phone", "Tablet", "Phone", "Laptop",
        "Phone", "Charger", "Laptop", "Tablet", "Charger",
        "Phone", "Laptop", "Tablet", "Headphones", "Tablet");

    // store all the products and their frequency in a hashmap
    HashMap<String, Integer> map = new HashMap<>();
    for (String product : products) {
      map.put(product, map.getOrDefault(product, 0) + 1);
    }

    // sort the frequencyof list
    List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

    list.sort(new Comparator<Map.Entry<String, Integer>>() {
      public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        return e2.getValue().compareTo(e1.getValue());
      }
    });

    //display the sorted list
    System.out.println("The products ordered are:");
    for (Map.Entry<String, Integer> e : list) {
      System.out.println("Product:" + e.getKey() + " Frequency:" + e.getValue());
    }

  }

}
