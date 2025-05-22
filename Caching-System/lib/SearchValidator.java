package lib;

import java.util.*;
import java.util.Scanner;

public class SearchValidator {

  public static int integerValidator(Scanner sc) {
    while (true) {
      try {
        return sc.nextInt();
      } catch (InputMismatchException e) {
        System.err.println("enter a valid input");
        sc.nextLine();
      }
    }
  }

}
