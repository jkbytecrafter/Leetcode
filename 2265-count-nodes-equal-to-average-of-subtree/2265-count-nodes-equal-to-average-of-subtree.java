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
    private int result=0;
    public int[] solve(TreeNode root){
        if(root == null) return new int[]{0,0};
        int[] lsum=solve(root.left);
        int[] rsum=solve(root.right);
        int totalSum=lsum[0] + rsum[0] + root.val;
        int count=lsum[1] + rsum[1] + 1;
        int avg=totalSum / count;
        if(avg == root.val) result++;
        return new int[]{totalSum,count};
    }
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return result;
    }
}