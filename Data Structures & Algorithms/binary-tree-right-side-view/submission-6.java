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
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        bfs(root, 0);
        return res;
    }

    private void bfs(TreeNode curr, int level) {
        if(curr == null) return;
        

        if(res.size() == level) {
            res.add(curr.val);
        }
        bfs(curr.right, level+1);
        bfs(curr.left, level+1);
    }
}
