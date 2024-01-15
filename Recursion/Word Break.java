// 139. Word Break

// Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

// Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

// Example 1:

// Input: s = "leetcode", wordDict = ["leet","code"]
// Output: true
// Explanation: Return true because "leetcode" can be segmented as "leet code".
// Example 2:

// Input: s = "applepenapple", wordDict = ["apple","pen"]
// Output: true
// Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
// Note that you are allowed to reuse a dictionary word.
// Example 3:

// Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
// Output: false
 

// Constraints:

// 1 <= s.length <= 300
// 1 <= wordDict.length <= 1000
// 1 <= wordDict[i].length <= 20
// s and wordDict[i] consist of only lowercase English letters.
// All the strings of wordDict are unique.

// Approach:- we will use 2 pointers start, and end to iterate 
// over the substring obtained we will check it in the 
// wordDict, and return true or false
// we will use recusrion + dp to store ans

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[][] dp = new int[s.length()][s.length()];
        for(int []i: dp) {
            Arrays.fill(i, -1);
        }
        return solve(0, 0, s, new HashSet<>(wordDict), dp);
    }

    private boolean solve(int start, int end, String s, Set<String> wd, int[][] dp) {
        if(dp[start][end] != -1) {
            return dp[start][end] == 1 ? true : false;
        }

        if(end == s.length()-1) {
            if(wd.contains(s.substring(start, end+1))) {
                return true;
            } else {
                return false;
            }
        }

        if(wd.contains(s.substring(start, end+1))) {
            if(solve(end+1, end+1, s, wd, dp)) {
                dp[start][end] = 1;
                return true;
            }
        }

        boolean ans = solve(start, end+1, s, wd, dp);
        dp[start][end] = ans ? 1:0;
        return ans;
    }
}