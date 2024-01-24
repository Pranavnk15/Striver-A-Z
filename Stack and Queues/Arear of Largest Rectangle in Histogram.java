/*Area of Largest Rectangle In Histogram

Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
 

Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104

Intuition: The intuition behind the approach is the same as finding the smaller element on both sides but in an optimized way using the concept of the next greater element and the next smaller element.

Approach: 

Steps to be done for finding Left smaller element




2. Steps to be done for finding the Right smaller element


After finding the right smaller and left smaller of each subsequent array elements, we


Area for first index – ( 0 – 0 +1 ) * 2 = 2

Area for second index – (6 – 0 + 1) * 1 = 6

Area for third index – (3 – 2 +1 ) * 5 = 10

Area for fourth index – (3 – 3 + 1 ) * 6 = 6

Area for fifth index – (5 – 2 +1 ) * 2 = 8

Area for sixth index – (5 – 5  + 1) * 3 = 3

Area for seventh index – (6 – 0 +1) * 1  = 7

So, the maximum area out of these is 10 sq units.

*/
class Solution {
    public int largestRectangleArea(int[] arr) {
       int n = arr.length;
       Stack<Integer> s = new Stack<>();
       int leftSmall[] = new int[n];
       int rightSmall[] = new int[n];
       for(int i = 0; i<n; i++) {
           while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
               s.pop();
           }

           if(s.isEmpty()) leftSmall[i] = 0;
           else leftSmall[i] = s.peek()+1;
           s.push(i);
       }

       s.clear();
       for(int i = n-1; i>=0; i--) {
           while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
               s.pop();
           }
           if(s.isEmpty()) rightSmall[i] = n-1;
           else rightSmall[i] = s.peek()-1;
           s.push(i);
       }

       int max = 0;
       for(int i = 0; i<n; i++) {
           max = Math.max(max, arr[i]*(rightSmall[i]-leftSmall[i]+1));
       }
       return max;
    }
}