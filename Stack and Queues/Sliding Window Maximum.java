/*239. Sliding Window Maximum


You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length


Approach:-
We wil store elements in decreasing order in a deque, 
when looking from front, we get the max of that window & further we check 
from the front whether that index is in the given range, 
if not we removeit from the front, 
and then from back we check if that element is, 
is less than the curr element, if yes then we pop it, 

*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i<nums.length; i++) {
            if(!q.isEmpty() && q.peek() == i-k) {
                q.poll(); //remove no. out of the range k
            }
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast(); //remove smaller no in K range
            }
            q.offer(i);
            if(i>=k-1) {
                r[ri++] = nums[q.peek()];
            }
        }
        return r;
    }
}