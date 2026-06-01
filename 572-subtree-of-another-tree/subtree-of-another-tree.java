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
        if(root==null)
        {
            return false;
        }
        if(root.val==subRoot.val && isSame(root,subRoot))
        {
            return true;
        }
        
            return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
}
    boolean isSame(TreeNode root,TreeNode subRoot)
    {
        if(root==null && subRoot==null)
        {
            return true;
        }
        if(root==null || subRoot==null)
        {
            return false;
        }
        if(root.val!=subRoot.val)
        {
            return false;
        }
       boolean r1 = isSame(root.left,subRoot.left);
        boolean r2 = isSame(root.right,subRoot.right);
        if(r1==true && r2==true)
        {
            return true;
        }
        return false;
    }
}