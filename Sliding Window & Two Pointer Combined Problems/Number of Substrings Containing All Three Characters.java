/*1358. Number of Substrings Containing All Three Characters

Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
Example 3:

Input: s = "abc"
Output: 1
 

Constraints:

3 <= s.length <= 5 x 10^4
s only consists of a, b or c characters.

*/
class Solution {
    public int numberOfSubstrings(String s) {
      int[] abc = new int[3];
      int start = 0;
      int ans = 0;
      for(int end = 0; end < s.length(); end++) {
            abc[s.charAt(end) - 'a']++;
            while(abc[0] >= 1 && abc[1] >= 1 && abc[2] >= 1) {
                ans += (s.length()-end);
                abc[s.charAt(start)-'a']--;
                start++;
            }
        }
        return ans;
    }
}