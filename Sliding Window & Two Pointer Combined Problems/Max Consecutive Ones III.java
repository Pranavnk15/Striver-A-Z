/* 1004. Max Consecutive Ones III

Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

 

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

Approach:-
Two Pointer Approach, we will use two pointer start and end, starting with 
pointing to 0th index. 
1) If the element at the end index is 1, then wemove ahead end by One
2) if the element at the end index is zero, and the value of 
the flippedOnes if less than k, then we flipped the zero, increase the flippedOnes value
by one, and move ahead end by one,
3) if the element at the end index is zero, and the value of the flippedOnes is greater
than or equal to the k, then we check the nums[start] == 0, if yes, then 
we reduce the flippedOnes by 1, and move the start pointer ahead;
4) We calculate the maxLen = max(maxLen, end-start)

*/

class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int flippedOnes = 0;
        int maxLen = 0;
        while(end < nums.length) {
            if(nums[end] == 1) {
                end++;
            } else {
                if(flippedOnes < k) {
                    flippedOnes++;
                    end++;
                } else {
                    while(flippedOnes >= k) {
                        if(nums[start] == 0){
                            flippedOnes--;
                        }
                        start++;
                    }
                }
            }
            maxLen = Math.max(maxLen, end-start);
        }
        return maxLen;
    }
}