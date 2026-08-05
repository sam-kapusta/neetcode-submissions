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
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return 1 + bfs(root.left, root.val)+ bfs(root.right, root.val);
    }

    private int bfs(TreeNode curr, int maxSeen) {
        if(curr == null) return 0;
        int sum = 0;
        if(curr.val >= maxSeen) {
            maxSeen = curr.val;
            sum += 1;
        } 
        sum += bfs(curr.left, maxSeen);
        sum += bfs(curr.right, maxSeen);
        return sum;
    }
}
