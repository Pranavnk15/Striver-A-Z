/*930. Binary Subarrays With Sum

Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.

 

Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15
 

Constraints:

1 <= nums.length <= 3 * 104
nums[i] is either 0 or 1.
0 <= goal <= nums.length

Intuition
To find exactly k goals we can find atmost(k) - atmost(k-1)

Approach
Increase window size until you reach the condition for sum lesser than equal to k then
reduce the window untils the sum become lesser than k
checking the contion and saving the ans
Complexity
Time complexity: O(n)O(n)O(n)
Space complexity:O(1)O(1)O(1)

*/

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int x = solve(nums, goal);
        int y = solve(nums, goal-1);
        return x-y;
    }

    public int solve(int[] nums, int k) {
        if(k<0) {
            return 0;
        }
        int s = 0;
        int e = 0;
        int sum = 0;
        int ans = 0;
        while(e<nums.length) {
            sum += nums[e];
            while(sum > k && s<nums.length) {
                sum -= nums[s];
                s++;
            }
            if(sum <= k) {
                ans += e-s+1;
            }
            e++;
        }
        return ans;
    }
}