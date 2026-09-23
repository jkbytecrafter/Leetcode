class Solution {
    int goodNodes = 0;

    public void solve(TreeNode root, int max) {
        if(root == null) return;
        if(root.val >= max) {
            goodNodes++;
            max = root.val;
        }
        solve(root.left, max);
        solve(root.right, max);
    }
    public int goodNodes(TreeNode root) {
        solve(root, Integer.MIN_VALUE);
        return goodNodes;
    }
}