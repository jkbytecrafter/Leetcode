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
        int ans=0;
        public int longestZigZag(TreeNode root) {
            
            helper(root, true, 0);
            helper(root, false, 0);
            return ans;
        }
        private void helper(TreeNode root,boolean left ,int cnt){
            if(root==null) return;
            ans=Math.max(ans,cnt);

            if(left){
                helper(root.left,true,1);
                helper(root.right,false,cnt+1);
            }
            else{
                helper(root.left,true,cnt+1);
                helper(root.right,false,1);
            }
        }
    }