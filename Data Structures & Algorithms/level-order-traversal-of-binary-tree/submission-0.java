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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> vals = new ArrayList<>();
        bfs(root, 0, vals);
        return vals;
    }

    private void bfs(TreeNode curr, int level, List<List<Integer>> vals) {
        if(curr == null) return;
        if(vals.size() <= level) {
            vals.add(new ArrayList<Integer>());
        }
        vals.get(level).add(curr.val);

        bfs(curr.left, level+1, vals);
        bfs(curr.right, level+1, vals);

    }

}
