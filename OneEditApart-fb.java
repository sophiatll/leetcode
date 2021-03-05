/*
Question 3: Edit Distance
Write a function that returns whether two words are exactly "one edit" away using the following signature:
bool OneEditApart(string s1, string s2);

An edit is:
Inserting one character anywhere in the word (including at the beginning and end)
Removing one character
Replacing one character

Examples:
OneEditApart("cat", "dog") = false 
OneEditApart("cat", "cats") = true
OneEditApart("cat", "cut") = true
OneEditApart("cat", "cast") = true
OneEditApart("cat", "at") = true
OneEditApart("cat", "act") = false

*/

/*
Solution:
removing 1 char
== inserting one char

1. the length of two strings can be same or different ( + 1, or -1)
2. for same lentgh, if more than one diff chars are found, return false
3. for different length, if diff(len1, len2) > 1, return false;
4. otherwise, compare each char of two strings
    if found the first diff char in longer string, skip it. 
    if found the second diff char, return false.
   
*/

class Solution {
  public static boolean oneEditApart(String s1, String s2) {
    
    if(Math.abs(s1.length()-s2.length()) >1) return false;
    
    
    String longStr = s1.length()>=s2.length()? s1: s2;
    String shortStr = s1.length()>=s2.length()? s2: s1;
    
    int i = 0;
    int j = 0;
    boolean foundDiff = false;
    
    while(i<longStr.length() && j<shortStr.length()) {
      if(longStr.charAt(i) != shortStr.charAt(j)) {
        if(foundDiff) return false;
        
        foundDiff = true;
        if(longStr.length() == shortStr.length()) {
          i++;
          j++;
        }
        else {
          i++;
        }
      } else {
        i++;
        j++;
      }
    }
    return foundDiff || longStr.length()>shortStr.length();
  }
  
  public static void main(String[] args) {
    System.out.println(oneEditApart("cat", "dog"));
    System.out.println(oneEditApart("cat", "cit"));
    System.out.println(oneEditApart("cat", "cats"));
    System.out.println(oneEditApart("cat", "cast"));
    System.out.println(oneEditApart("cat", "at"));
    System.out.println(oneEditApart("cat", "ats"));
    System.out.println(oneEditApart("cat", "cat"));
  }
}

