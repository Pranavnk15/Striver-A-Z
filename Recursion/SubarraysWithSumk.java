// Problem statement
// You are given an array 'A' of size 'N' and an integer'K'’. You need to generate and return all subarrays of array ‘A’ whose sum = ‘K’.



// Note: In the output, you will see the 2D array lexicographically sorted.



// Example:
// Input: ‘N’ = 6 ‘K’ = 3
// ‘A’ = [1, 2, 3, 1, 1, 1]
// Output: 3
// Explanation: Subarrays whose sum = ‘3’ are:
// [1, 2], [3], and [1, 1, 1]



import java.util.*;
public class Solution {
    public static List< List < Integer > > subarraysWithSumK(int []a, long k) {
        // Write your code here
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i<a.length; i++) {
            long currSum = 0;
            List<Integer> temp = new ArrayList<>();
            for(int j = i; j<a.length; j++) {
                temp.add(a[j]);
                currSum += a[j];
                if(currSum ==k) {
                    ans.add(new ArrayList(temp));
                }
            }
        }
        return ans;
    }
}