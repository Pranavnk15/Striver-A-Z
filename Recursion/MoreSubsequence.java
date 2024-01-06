// More subsequence
// Problem statement
// You are given two strings 'A' and 'B' of length 'N' and 'M' respectively.



// Return the string that has more distinct subsequences, if both strings have the same number of distinct subsequences, then return 'A'.



// For Example:
// 'N' = 2, 'M' = 2, 'A' = "ab", 'B' = "dd".

// 'A' has distinct subsequences = ["a", "b", "ab"].
// 'B' has distinct subsequences = ["d", "dd"].
// So our answer is "ab".


import java.util.*;

public class Solution {
    public static String moreSubsequence(int n, int m, String a, String b) {
        // Write your code here
        if(func(a, n) >= func(b, m)) {
            return a;
        } else {
            return b;
        }
    }
    public static int func(String s, int n) {
        // Initializing 'count' with 1.
        int count = 1;

        // Creating a HashMap of [char, int] 'm1'.
        HashMap<Character, Integer> m1 = new HashMap<>();

        // Calculating number of distinct subsequences.
        for (int i = 0; i < n; i++) {
            if (!m1.containsKey(s.charAt(i))) {
                m1.put(s.charAt(i), count);
                count *= 2;
            } else {
                int temp = m1.get(s.charAt(i));
                m1.put(s.charAt(i), count);
                count *= 2;
                count -= temp;
            }
        }
        return count;
    }

}
