class Solution {
    public int solve(int[] cost,int i,int[] dp){
        int n=cost.length;
        if(i>=n) return 0;
        if(i==n-1) return cost[i];
        if(dp[i] != -1) return dp[i];
        int takeone=cost[i]+solve(cost,i+1,dp);
        int taketwo=cost[i]+solve(cost,i+2,dp);
        return dp[i]=Math.min(takeone,taketwo);
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] dp=new int[cost.length];
        Arrays.fill(dp,-1);
        int start0=solve(cost,0,dp);
        int start1=solve(cost,1,dp);
        return (start0 < start1) ? start0 : start1;
    }
}