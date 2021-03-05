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
    int l1 = s1.length();
    int l2 = s2.length();
    
    if(Math.abs(l1-l2) >1) return false;
    
    if(l1 == l2) {
      return oneReplace(s1, s2);
    }
    else {
      return oneDelete(s1, s2);
    }
    
    
  }
  
  private static boolean oneReplace(String s1, String s2) {
    boolean foundOneDiff = false;
    for(int i=0; i<s1.length(); i++) {
      if(s1.charAt(i) != s2.charAt(i)){
        if(foundOneDiff) return false;
          
        foundOneDiff = true;
      }
    }
    return true;
  }
  
  private static boolean oneDelete(String s1, String s2) {
    String longStr = s1;
    String shortStr = s2;
    if(s2.length()>s1.length()){
      longStr = s2;
      shortStr = s1;
    }
    boolean foundOneDiff = false;
    //"cat" "at"
    for(int i=0, j=0; j<shortStr.length(); i++) {
      if(longStr.charAt(i) != shortStr.charAt(j)){
        if(foundOneDiff)  return false;
        
        foundOneDiff = true;
      }
      else {
        j++;
      }
    }
    return true;
  }
  
  
  public static void main(String[] args) {
    System.out.println(oneEditApart("cat", "dog"));
    System.out.println(oneEditApart("cat", "cit"));
    System.out.println(oneEditApart("cat", "cats"));
    System.out.println(oneEditApart("cat", "cast"));
    System.out.println(oneEditApart("cat", "at"));
    System.out.println(oneEditApart("cat", "ats"));
  }
}

