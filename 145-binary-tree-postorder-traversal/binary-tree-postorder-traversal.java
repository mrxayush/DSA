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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        fun(root,list);
        return list;
    }
    void fun(TreeNode node , List<Integer> list)
    {
        if(node==null)
        {
            return;
        }
        fun(node.left,list);
        fun(node.right,list);
        list.add(node.val);
        return;
    }
}