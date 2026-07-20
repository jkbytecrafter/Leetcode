class Solution {
    public int help(int[] nums,int[][] dp,int i,int p){
        if(i >= nums.length) return 0;
        if(p!=-1 && dp[i][p]!=-1) return dp[i][p];
        int take=0,skip=0;
        if(p==-1 || nums[p]<nums[i]) take=help(nums,dp,i+1,i)+1;
        skip=help(nums,dp,i+1,p);
        if(p!=-1) dp[i][p]=Math.max(take,skip);
        return Math.max(take,skip);
    }
    public int lengthOfLIS(int[] nums) {
        int[][]dp=new int[nums.length+1][nums.length+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return help(nums,dp,0,-1);
    }
}