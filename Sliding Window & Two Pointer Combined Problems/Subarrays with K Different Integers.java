/* 992. Subarrays with K Different Integers


Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
Example 2:

Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 

Intuition
Exactly k distinct integers means : Atmost (k) distinct integers - Atmost (k - 1) distinct integers.

Approach
Here I have used sliding window combined with two pointers approach.

Fix a pointer 'j' at the beginning of the array and traverse the array using 'i' and keep on storing the elements in the map, till the size of the map does not exceeds (k).
As it exceeds k, start deleting the elements from the beginning of the array using the j pointer and after deleting the elements increment the j pointer.
Each time calculate the distinct subarrays in the sliding window and add it to our answer.
By performing this algorithm once, we'll get subarrays with atmost k elements.
Perform same algorithm for atmost k - 1 elements and subtract the latter from the first part.
Complexity
Time complexity: O(n)
Traversing the array.

Space complexity: O(k)
Size of the map will never exceed k.
*/

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmostK(nums, k) - atmostK(nums, k-1);        
    }

    private int atmostK(int[] nums, int k) {
        int start = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int end = 0; end<nums.length; end++) {
            map.put(nums[end], map.getOrDefault(nums[end], 0)+1);
            while(map.size() > k) {
                if(map.get(nums[start])  > 1) {
                    map.put(nums[start], map.get(nums[start]) -1);
                } else {
                    map.remove(nums[start]);
                }
                start++;
            }
            ans+= (end-start+1);
        }
        return ans;
    }
}

