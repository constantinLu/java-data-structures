import java.util.LinkedList;

/**
 * Tester for SinglyLinkedList.
 */
public class SinglyLinkedListTester {

  /**
   * Main method in the Tester to run. Does not test iterator yet.
   */
  public static void main(String[] args) {
    SinglyLinkedList<Integer> test;
    LinkedList<Integer> base;

    for (int i = 0; i < 10; i++) { // 10 test runs
      System.out.print("\n\nNEW RUN\n\n");
      test = new SinglyLinkedList<>(); // SinglyLinkedList that will be tested
      base = new LinkedList<>(); // Base list to verify the SinglyLinkedList functionality

      // Add 6 values to each list
      for (int j = 1; j < 7; j++) {
        int randomInt = random(i);
        System.out.print("Adding " + randomInt + " to list.\n");
        test.add(randomInt);
        base.add(randomInt);
      }
      tester(test, base);

      // Test get function
      System.out.print("Test get function at 3rd index\n");
      System.out.print("Base list value at 3rd index: " + base.get(2) + "\n");
      System.out.print("Your list value at 3rd index: " + test.get(2) + "\n");
      if (!test.get(2).equals(base.get(2))) {
        throw new RuntimeException("Get function doesn't work.");
      }

      // Remove the value at the 4th index
      System.out.print("\nRemoving the 4th value in list, " + base.get(3) + "\n");
      int testRemoved = test.remove(3);
      int baseRemoved = base.remove(3);
      if (testRemoved != baseRemoved) {
        throw new RuntimeException("Remove function doesn't work.");
      }
      tester(test, base);
    }
    System.out.println("\nSinglyLinkedList Implementation Passed.");
  }

  private static void tester(SinglyLinkedList test, LinkedList<Integer> base) {
    // Check to string function (will check values in order, etc)
    System.out.print("\nTesting to string.\n");
    System.out.print("Base list: " + base.toString() + "\n");
    System.out.print("Your list: " + test.toString() + "\n");
    if (!test.toString().equals(base.toString())) {
      throw new RuntimeException("toString doesn't match");
    }

    // Check list sizes
    System.out.print("\nTesting list sizes.\n");
    System.out.print("Base list size: " + base.size() + "\n");
    System.out.print("Your list size: " + test.length() + "\n\n");
    if (test.length() != base.size()) {
      throw new RuntimeException("Size is " + test.length() + " and should be " + base.size());
    }
  }

  // Generate a random number
  private static int random(int n) {
    return (int)(Math.random() * n);
  }

}
