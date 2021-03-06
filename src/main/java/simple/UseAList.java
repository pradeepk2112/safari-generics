package simple;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UseAList {
  public static void breakIt(List l) { // Legacy code!
    l.add(0, LocalDate.now()); // adding wrong types in this way "Heap Pollution"
  }

  public static void main(String[] args) {
//    List<String> name = new ArrayList<String>(Arrays.asList(LocalDate.now(), "Alice"));
    // "List of String" is not "real" -- "non-reifiable" type...
    List<String> name = new ArrayList<>(Arrays.asList("Alice")); // "diamond" (Java 7+)
    name.add("Fred");
    name.add("Jim");
    name.add("Sheila");

//    name.add(0, LocalDate.now());

//    breakIt(name);
//    String theName = (String)name.get(0);
    String theName = name.get(0); // Cast still exists, generated by compiler
    System.out.println("First name is " + theName);

//    if (name instanceof List<String>) { List<String> is non-reifiable, not real!!!
    if (name instanceof List) {
      System.out.println("Yes, it's a list");
    }
  }
}
