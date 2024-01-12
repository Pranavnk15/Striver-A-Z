// 131. Palindrome Partitioning

// Given a string s, partition s such that every 
// substring
//  of the partition is a 
// palindrome
// . Return all possible palindrome partitioning of s.

 

// Example 1:

// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]
// Example 2:

// Input: s = "a"
// Output: [["a"]]
 

// Constraints:

// 1 <= s.length <= 16
// s contains only lowercase English letters.


class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        solve(0, s, path, res);
        return res;
    }

    public static void solve(int i, String s, List<String> path, List<List<String>> res) {
        if(i == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int j = i; j<s.length(); j++) {
            if(isPalindrome(s, i, j)) {
                path.add(s.substring(i, j+1));
                solve(j+1, s, path, res);
                path.remove(path.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s, int start, int end) {
        while(start<=end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}