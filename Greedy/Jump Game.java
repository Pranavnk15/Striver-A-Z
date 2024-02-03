/*55. Jump Game

You are given an integer array nums. You are initially positioned at the array's 
first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length 
is 0, which makes it impossible to reach the last index.
*/

class Solution {
    public boolean canJump(int[] nums) {
        //initially the final position is the last index
        int finalPosition = nums.length-1;

        //start from the second last index
        for(int idx = nums.length-2; idx>=0; idx--) {
            //if you can reach the finalPosition from current idx
            // then update the finalPosition to the curr idx
            if(idx + nums[idx] >= finalPosition) {
                finalPosition = idx;
            }
        }

        //if we reach the last idex i.e 0th index, we return true
        return finalPosition == 0;
    }
}