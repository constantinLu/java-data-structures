import java.util.LinkedList;

/**
 * Tester for DoublyLinkedList.
 */
public class DoublyLinkedListTester {

  /**
   * Main method in the Tester to run. Does not test iterator yet.
   */
  public static void main(String[] args) {

    DoublyLinkedList<Integer> test;
    LinkedList<Integer> base;

    for (int i = 0; i < 10; i++) { // 10 test runs
      System.out.print("\n\nNEW RUN\n\n");
      test = new DoublyLinkedList<>(); //DoublyLinkedList that will be tested
      base = new LinkedList<>(); //base list to verify the doublylinkedlist functionality

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

      // Add a value at the 3rd index
      int randomInt = random(i);
      System.out.print("\nAdding " + randomInt + " to list at 3rd index.\n");
      test.add(2, randomInt);
      base.add(2, randomInt);
      if (test.get(2) != randomInt) {
        throw new RuntimeException("Add at index function doesn't work.");
      }
      tester(test, base);

      // Remove the value at the 4th index
      System.out.print("\nRemoving the 4th value in list, " + base.get(3) + "\n");
      int testRemoved = test.remove(3);
      int baseRemoved = base.remove(3);
      if (testRemoved != baseRemoved) {
        throw new RuntimeException("Remove function doesn't work.");
      }
      tester(test, base);
    }
    System.out.println("\nDoublyLinkedList Implementation Passed.");
  }

  private static void tester(DoublyLinkedList test, LinkedList<Integer> base) {

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
    System.out.print("Your list size: " + test.size() + "\n\n");
    if (test.size() != base.size()) {
      throw new RuntimeException("Size is " + test.size() + " and should be " + base.size());
    }
  }

  private static int random(int n) {
    return (int)(Math.random() * n);
  }

}
