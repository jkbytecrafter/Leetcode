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
    int cnt=0;
    public int helper(TreeNode node){
        if(node==null) return Integer.MIN_VALUE;
        if(node.left==null && node.right==null) {
            cnt++;
            return node.val;
        }
        int left=helper(node.left);
        int right=helper(node.right);
        if(node.val>=Math.max(left,right)){
            cnt++;
            return node.val;
        }
        return Math.max(left,right);
         
    }
    public int countDominantNodes(TreeNode root) {
        helper(root);
        return cnt;
    }
}