class Solution {
    public int solve(int[] satisfaction,int i,int time,int[][] dp){
        if(i>=satisfaction.length) return 0;
        if(dp[i][time]!=-1) return dp[i][time];
        int include = satisfaction[i]*time + solve(satisfaction,i+1,time+1,dp);
        int skip = solve(satisfaction,i+1,time,dp);
        return dp[i][time] = Math.max(include,skip);
    }
    public int maxSatisfaction(int[] satisfaction) {
        int[][] dp=new int[501][501];
        for(int[] row:dp) Arrays.fill(row,-1);
        Arrays.sort(satisfaction);
        return solve(satisfaction,0,1,dp);
    }
}