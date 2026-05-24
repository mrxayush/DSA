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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int lefttoright = 1;
    while(!q.isEmpty())
    {
        int lvlsize = q.size();
       int[] arr = new int[lvlsize];
        int firstidx = 0;
        int lastidx = lvlsize-1;
        while(lvlsize-->0)
        {
            TreeNode t = q.element();
            q.poll();
            if(lefttoright==1)
            {
                arr[firstidx]=t.val;
                firstidx++;
            }
            else
            {
                arr[lastidx]=t.val;
                lastidx--;
            }
            if(t.left!=null)
            {
                q.offer(t.left);
            }
            if(t.right!=null)
            {
                q.offer(t.right);
            }
        }
        lefttoright =1-lefttoright;
        List<Integer> temp = new ArrayList<>();
        for(int x : arr)
        {
            temp.add(x);
        }
        res.add(temp);
    }
    return res;
    }
    }
