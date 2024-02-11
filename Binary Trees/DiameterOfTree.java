// 543. Diameter of Binary Tree

// Given the root of a binary tree, return the length of the diameter of the tree.

// The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

// The length of a path between two nodes is represented by the number of edges between them.

 


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
    static class Info{
        int diameter;
        int height;
        public Info(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return optimizeDiameter(root).diameter;    
    }

    public static Info optimizeDiameter(TreeNode root){
        if(root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = optimizeDiameter(root.left);
        Info rightInfo = optimizeDiameter(root.right);
        
        int currDia = Math.max(leftInfo.height+rightInfo.height, Math.max(leftInfo.diameter, rightInfo.diameter));
        int currHeight = Math.max(leftInfo.height, rightInfo.height)+1;
        
        return new Info(currDia, currHeight);
    }
}