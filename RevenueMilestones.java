import java.util.*;
// Add any extra import statements you may need here


class RevenueMilestones {



  int[] getMilestoneDays(int[] revenues, int[] milestones) {
      // Write your code here
      int[] result = new int[milestones.length];
      Queue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> {
          return milestones[o1] - milestones[o2];
      });
    
      for (int i = 0; i < milestones.length; i++) {
          minHeap.offer(i);
      }
    
      int total = 0;
      int i = 0;
      while (i < revenues.length && !minHeap.isEmpty()) {
          if (total >= milestones[minHeap.peek()]) {
              result[minHeap.poll()] = i;
              continue;
          }
          total += revenues[i];
          i++;
      }
      while (!minHeap.isEmpty()) {
          if (total >= milestones[minHeap.peek()]) {
              result[minHeap.poll()] = i;
          } else {
              result[minHeap.poll()] = -1;
          }
      }
      return result;

  }












  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;
  void check(int[] expected, int[] output) {
    int expected_size = expected.length; 
    int output_size = output.length; 
    boolean result = true; 
    if (expected_size != output_size) {
      result = false;
    }
    for (int i = 0; i < Math.min(expected_size, output_size); i++) {
      result &= (output[i] == expected[i]);
    }
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);  
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printIntegerArray(expected); 
      System.out.print(" Your output: ");
      printIntegerArray(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printIntegerArray(int[] arr) {
    int len = arr.length; 
    System.out.print("[");
    for(int i = 0; i < len; i++) {
      if (i != 0) {
        System.out.print(", ");
      }
      System.out.print(arr[i]);
    }
    System.out.print("]");
  }
  public void run() {
    int revenues_1[] = {100, 200, 300, 400, 500};
    int milestones_1[] = {300, 800, 1000, 1400};
    int expected_1[] = {2, 4, 4, 5};
    int[] output_1 = getMilestoneDays(revenues_1, milestones_1);
    check(expected_1, output_1);
    
    int revenues_2[] = {700, 800, 600, 400, 600, 700};
    int milestones_2[] = {3100, 2200, 800, 2100, 1000};
    int expected_2[] = {5, 4, 2, 3, 2};
    int[] output_2 = getMilestoneDays(revenues_2, milestones_2);
    check(expected_2, output_2);
  
    // Add your own test cases here
    
  }
  
  public static void main(String[] args) {
    new RevenueMilestones().run();
  }
}
