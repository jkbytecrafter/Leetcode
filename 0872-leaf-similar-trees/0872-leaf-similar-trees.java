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
    public void getLeaf(TreeNode root,List<Integer> lst){
        if(root==null) return;
        if(root.left==null && root.right==null) lst.add(root.val);
        getLeaf(root.left,lst);
        getLeaf(root.right,lst);

    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
         List<Integer> l1=new ArrayList<>();
         getLeaf(root1,l1);
         List<Integer> l2=new ArrayList<>();
         getLeaf(root2,l2);
         int s1=l1.size();
         int s2=l2.size();
         if(s1 != s2) return false;
         for(int i=0;i<s1;i++){
            if(!l1.get(i).equals(l2.get(i))) return false;
         }
         return true;
    }
}