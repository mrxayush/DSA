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
    TreeNode ans = null;
    TreeNode fun(TreeNode root , int val)
    {
        TreeNode ans = null;
        if(root==null)
        {
            return null;
        }
        if(root.val==val)
        {
            ans=root;
            return ans;
        }
        if(root.val>val)
        {
            return searchBST(root.left,val);
        }
        else{
           return searchBST(root.right,val);
        }
    }
    public TreeNode searchBST(TreeNode root, int val) {
        return fun(root,val);
    }
}