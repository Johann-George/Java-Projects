import java.util.LinkedHashMap;
import java.util.Scanner;

class Search {

  LinkedHashMap<String, String> map = new LinkedHashMap<>();

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    Search search = new Search();
    search.search(sc);

  }

  public void search(Scanner sc) {

    int cont = 1;
    while (cont != 0) {
      System.out.println("Enter the keyword you want to search:");
      String keyword = sc.nextLine();
      String result = getSearchResult(keyword, sc);
      System.out.println(result);
      System.out.println("Do you want to continue(1/0):");
      cont = sc.nextInt();
      sc.nextLine();
    }
  }

  public String getSearchResult(String key, Scanner sc) {

    String searchResult;
    if (map.containsKey(key)) {
      System.out.println("The key is found in cache");
      searchResult = map.get(key);
    } else {
      System.out.println("The key is not found in cache");
      System.out.println("Fetching from database");
      System.out.println("Enter the search result:");
      searchResult = sc.nextLine();
      if (map.size() > 4) {
        map.remove(map.keySet().iterator().next());
      }
      map.put(key, searchResult);
    }
    System.out.println("The search result is:");
    return searchResult;
  }

}
