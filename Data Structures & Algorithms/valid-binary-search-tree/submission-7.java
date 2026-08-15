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
    public boolean isValidBST(TreeNode root) {
        
        //everything in left is smaller then root, everything in right is smaller then root. 
        if(root == null) return false;
        return dfs(root.left, Integer.MIN_VALUE, root.val) && dfs(root.right, root.val, Integer.MAX_VALUE);

    }

    private boolean dfs(TreeNode curr, int min, int max) {
        if(curr == null) return true;
        if(!(curr.val > min && curr.val < max)) return false;

        return dfs(curr.left, min, curr.val) && dfs(curr.right, curr.val, max);


    }
}
