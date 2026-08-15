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
        if(root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> currList = new ArrayList<TreeNode>();
        currList.add(root);
        List<Integer> intList = new ArrayList<Integer>();
        List<TreeNode> next = new ArrayList<>();
        
        while (!currList.isEmpty() ) {
            for(TreeNode curr : currList) {
                if(curr == null) continue;
                next.add(curr.left);
                next.add(curr.right);
                intList.add(curr.val);
            }
            if(!intList.isEmpty()) res.add(intList);
            currList = next;
            next = new ArrayList<>();
            intList = new ArrayList<>();
        }
        return res;
        
    }
}
