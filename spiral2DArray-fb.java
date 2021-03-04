/**
Find the pattern and complete the function: 
int[][] spiral(int n);
where n is the size of the 2D array.
Sample Result
input = 3
123
894
765

input = 4
01 02 03 04
12 13 14 05
11 16 15 06
10 09 08 07

input = 8
1 2 3 4 5 6 7 8
28 29 30 31 32 33 34 9
27 48 49 50 51 52 35 10
26 47 60 61 62 53 36 11
25 46 59 64 63 54 37 12
24 45 58 57 56 55 38 13
23 44 43 42 41 40 39 14
22 21 20 19 18 17 16 15
**/

/**
Partten:
1. traversal square bound from outside to inside
bound size : n, n-2, n-4, ..., 2 or 1

stop condition: bound size <=0;

2. 4 parts: up, right, buttom and left bound
square start from (i, j) 
each bound length (len)= bound size -1;

from = j;
to= j+len-1;
up : (from, j) to (i, to), j++

from = i;
to = i+len-1;
right: (from, j) to (to, j), i++

from = j;
to = j-len-1;
bottom: (i, from) to (i, to), j--

from = i
to = i-len-1;
left: (from, j) to (to, j), i--; 

3. for each step,
value++

**/

public class Solution{
  
  public static int[][] genSpiral(int n) {
    if(n<=0) {
      throw new IllegalArgumentException("n must be >=0"); 
    }
    
    int[][] a = new int[n][n];
    int value = 1;
    
    int i = 0;
    int j = 0;
    
    for(int boundSize = n; boundSize>=0; boundSize-=2) {
      System.out.println("bound size " + boundSize + ", i=" + j + ",j=" + j);
      if(boundSize == 1) {
        a[i][j] = value;
        break;
      }
      
      int len = boundSize-1;
      //up
      int to = j+len-1;
      for(; j<=to; j++) {
        a[i][j] = value++;
      }
      
      //right
      to = i+len-1;
      for(;i<=to; i++) {
        a[i][j] = value++;
      }
      
      //buttom
      to = j-len+1;
      for(; j>=to; j--) {
        a[i][j] = value++;
      }
      
      //left
      to = i-len+1;
      for(; i>=to; i--) {
        a[i][j] = value++;
      }
      
      i++;
      j++;
    }
    return a;
  }
  
  
  public static void main(String[] args){
    System.out.println("Test");
    
    int n=5;
    int[][] matrix = Solution.genSpiral(n);

    for(int i=0; i<n; i++) {
      for(int j=0; j<n; j++) {
        System.out.print(matrix[i][j] + " " );
      }
      System.out.println();
    }
    
  }
}
    
 
