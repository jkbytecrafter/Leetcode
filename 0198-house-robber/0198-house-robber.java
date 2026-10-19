class Solution {
    public int solve(int[] nums,int i,int[] dp){
        if(i>=nums.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int steal=solve(nums,i+2,dp)+nums[i];
        int skip=solve(nums,i+1,dp);
        return dp[i]=Math.max(skip,steal); 
    }
    public int rob(int[] nums) {
        int[] dp=new int[101];
        Arrays.fill(dp,-1);
        return solve(nums,0,dp);
    }
}