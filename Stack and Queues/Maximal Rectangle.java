/*85. Maximal Rectangle
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = [["0"]]
Output: 0
Example 3:

Input: matrix = [["1"]]
Output: 1
 
*/
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int arr[] = new int[n];
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(matrix[i][j] == '0'){
                    arr[j] = 0;
                } else {
                    arr[j] += 1;
                }
            }
            max = Math.max(max, helper(arr));
        }
        return max;
    }

    public int helper(int[] arr) {
        Deque<Pair<Integer, Integer>> st = new ArrayDeque<>();
        int max = 0;
        for(int i = 0; i<arr.length; i++) {
            int idx = i;
            while(st.size()>0 && st.peek().getKey()>=arr[i]) {
                Pair<Integer, Integer> p = st.pop();
                idx = p.getValue();
                int area = p.getKey()*(i-idx);
                max = Math.max(max, area);
            }
            st.push(new Pair<>(arr[i], idx));
        }
        while(st.size()>0) {
            Pair<Integer, Integer> p = st.pop();
            int area = p.getKey()*(arr.length-p.getValue());
            max = Math.max(max, area);
        }
        return max;
    }
}