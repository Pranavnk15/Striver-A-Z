// 110. Balanced Binary Tree

// Given a binary tree, determine if it is 
// height-balanced
// .

// A height-balanced binary tree is a binary tree in which the depth of 
// the two subtrees of every node never differs by more than one.


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
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(Height(root) == -1) {
            return false;
        }
        return true;
    }

    public int Height(TreeNode root) {
        if(root == null){
            return 0;
        }
        int lh = Height(root.left);
        int rh = Height(root.right);
        if(lh == -1 || rh == -1) {
            return -1;
        }
        if(Math.abs(lh - rh) > 1) {
            return -1;
        }
        return Math.max(lh, rh)+1;
    }
}