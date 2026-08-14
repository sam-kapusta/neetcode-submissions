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
            if(isIdentical(root, subRoot)) return true;
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        
    }

    public boolean isIdentical(TreeNode first, TreeNode second) {
        if(first == null && second == null) return true;
        if(first == null || second == null) return false;

        if(first.val != second.val) return false;
        return isIdentical(first.left, second.left) && isIdentical(first.right, second.right);
    }
}
