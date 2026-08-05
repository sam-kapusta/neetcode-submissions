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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;

        if(isMatching(root, subRoot)) return true; 

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isMatching(TreeNode root, TreeNode copy) {

        if(root == null && copy == null) return true;
        if(root == null || copy == null) return false;

        if(root.val != copy.val) return false;

        return isMatching(root.left, copy.left) && isMatching(root.right, copy.right);
    }
}
