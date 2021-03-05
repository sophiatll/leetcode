/**
Question 2: Look and Say
Implement a function that outputs the Look and Say sequence:
1 
11
21
1211
111221
312211
13112221
1113213211
31131211131221
13211311123113112211
**/

/**
To be clarified:
 - what's the look and say?
 - not digital other than 1, 2, 3 except to the seed 
 - the seed 22 will not grow up
 - should I assume the seed only should be 1 ?
**/

/**
input:
- the times to repeat the look and say
public void lookAndSay(int times);


Solution:
1. create the previous string

2. go through the previous string and compare current(i) and next(i+1) digital 
- if they are same, increase count
- otherwise, reset count to 0, append count+current digital to current string.

3. repeat step 2 until reach indicated times 
**/

/**
Test:
1) input 1
1
11

2) input 4

1
11
21
1211
111221
**/
import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void lookAndSay(int times) {
    if(times<=0) return;
    String prevStr = "1";
    
    while(times>0) {
           
      int count =0;
      String curStr = "";
      int len = prevStr.length();
      for(int i=0; i<len; i++) {
        count++;
        char cur = prevStr.charAt(i);
        if(i == len-1) {
          curStr = curStr + count + cur;
          break;
        }
        
        char next = prevStr.charAt(i+1);
        if(cur != next) {
          curStr = curStr + count + cur;
          count = 0;
        }
      }
      
      System.out.println(curStr);
      prevStr = curStr;
    
      times--;
    }
  }
  
  public static void main(String[] args) {
    lookAndSay(10);
  }
}

