/*
Find Minimum Number Of Coins

Problem statement
Given an infinite supply of Indian currency i.e. [1, 2, 5, 10, 20, 50, 100, 500, 1000] valued coins and an amount 'N'.



Find the minimum coins needed to make the sum equal to 'N'. You have to return the list containing the value of coins required in decreasing order.



For Example
For Amount = 70, the minimum number of coins required is 2 i.e an Rs. 50 coin and a Rs. 20 coin.
Note
It is always possible to find the minimum number of coins for the given amount. So, the answer will always exist.
*/

import java.util.*;
import java.util.List;
public class Solution {
    public static List<Integer> MinimumCoins(int n) {
        // Write your code here.
        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        Arrays.sort(coins, Comparator.reverseOrder());
        int countOfCoins = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i<coins.length; i++) {
            if(coins[i] <= n) {
                while(coins[i] <= n){
                    countOfCoins++;
                    ans.add(coins[i]);
                    n = n-coins[i];
                }
            }
        }
        return ans;
    }
}
