class Solution {
    public int solve(int[] rods,int diff,int idx,int[][] dp){
        if(idx>=rods.length) {
            if(diff == 0){
                return 0;
            }
            return Integer.MIN_VALUE;
        };
        if(dp[idx][diff+5000]!=-1) return dp[idx][diff+5000];
        int take_l1=rods[idx] + solve(rods,diff+rods[idx],idx+1,dp);
        int take_l2=rods[idx] + solve(rods,diff-rods[idx],idx+1,dp);
        int nothing=solve(rods,diff,idx+1,dp);
        return dp[idx][diff+5000] = Math.max(nothing,Math.max(take_l1,take_l2));
    }
    public int tallestBillboard(int[] rods) {
        //int[21][5001][5001]    -----> NOT POSSIBLE{MEMORY LIMIT EXCEED}
        int[][] dp=new int[21][100001];
        for(int[] row:dp) Arrays.fill(row,-1);
        return solve(rods,0,0,dp)/2;
    }
}