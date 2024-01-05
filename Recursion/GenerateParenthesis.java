// 22. Generate Parentheses

// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

// Example 1:

// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:

// Input: n = 1
// Output: ["()"]




class Solution {
    public List<String> generateParenthesis(int n) {
       List<String> ans = new ArrayList<>();
        findAll("(" , 1, 0, ans, n);
        return ans;
    }

    public static void findAll(String curr, int open, int close, List<String> ans, int n) {
        if(curr.length() == 2*n) {
            ans.add(curr);
            return;
        }
        
        if(open < n) {
            findAll(curr + "(", open+1, close, ans, n);
        }

        if(close < open) {
            findAll(curr+ ")", open, close+1, ans, n);
        }
    }
}