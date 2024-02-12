// 124. Binary Tree Maximum Path Sum

// Intuition
// Find what is the maximum path sum through a given node when that node is acting as the root.

// Approach
// At a given node with a value, if we find the max left_sum in the left-subtree and the max right_sum in the right subtree, then the maxPathSum through that node is :
// node.value + (left_sum + right_sum).

// Apply this formula at every node by doing a simple tree traversal and store the maximum value in an instance variable.

// In the recursive function, we find and compare the maxPathSum from a given node when it is the root of the path, but what we return is the maxPathSum of that same node when it is NOT the root of the path. To find the latter maxPath, we will simply take the maximum of the left_sum and right_sum and add it to the value of the node.

// Complexity
// Time complexity: O(n)
// Tree traversal

// Space complexity: O(n)



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int maxValue[] = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPath(root, maxValue);
        return maxValue[0];
    }

    public int maxPath(TreeNode root, int maxValue[]) {
        if(root == null) {
            return 0;
        }

        int left = Math.max(0, maxPath(root.left, maxValue));
        int right = Math.max(0, maxPath(root.right, maxValue));

        maxValue[0] = Math.max(maxValue[0], left+right+root.val);
        return Math.max(left, right)+root.val;
    }
}