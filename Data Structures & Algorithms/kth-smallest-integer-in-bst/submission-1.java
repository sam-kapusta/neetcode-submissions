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
    public int kthSmallest(TreeNode root, int k) {
        
        //kth smallest. So you need to build the tree I think in left - right model so not bst i forget the name. And then it's a simple lookup of going k from left

        List<Integer> inorder = new ArrayList<>();
        dfs(root, inorder);
        if(inorder.size() < k) return -1;
        return inorder.get(k-1);
    }

    private void dfs(TreeNode curr, List<Integer> inorder) {
        if(curr == null) return;
        dfs(curr.left, inorder);
        inorder.add(curr.val);
        dfs(curr.right, inorder);
    }
}
