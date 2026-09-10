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
    private int result;
    public int findSum(TreeNode root,int[] count){
        if(root== null){
            return 0;
        }
        count[0]++;
        int lsum=findSum(root.left,count);
        int rsum=findSum(root.right,count);
        return lsum+rsum+root.val;
    }
    public void solve(TreeNode root){
        if(root== null){
            return ;
        }
        int[] count = {0};
        int sum=findSum(root,count);
        if(root.val==sum/count[0]){
            result++;
        }
        solve(root.left);
        solve(root.right);
    }
    public int averageOfSubtree(TreeNode root) {
        result = 0;
        solve(root);
        return result;
    }
}