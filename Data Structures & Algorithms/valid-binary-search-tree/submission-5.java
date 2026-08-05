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
        return bfs(root, null, null);
    }

    private boolean bfs(TreeNode curr, Integer min, Integer max) {
        if(curr == null) return true;

        if(min != null && curr.val <= min) return false;
        if(max != null && curr.val >= max) return false;

        return bfs(curr.left, min, curr.val) && bfs(curr.right, curr.val, max);
    }
}
