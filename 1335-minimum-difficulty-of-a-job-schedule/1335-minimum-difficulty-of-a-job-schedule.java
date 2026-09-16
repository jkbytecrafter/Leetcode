class Solution {
    public int solve(int idx,int n,int d,int[] jD,int[][] dp){
        if(dp[idx][d] != -1) return dp[idx][d];
        if(d==1){
            int maxD=Integer.MIN_VALUE;
            for(int i=idx;i<n;i++){
                maxD=Math.max(maxD,jD[i]);
            }
            return maxD;
        }
        int maxD=Integer.MIN_VALUE;
        int result=0,finalResult=Integer.MAX_VALUE;
        for(int i=idx;i<=n-d;i++){
            maxD=Math.max(maxD,jD[i]);
            result=solve(i+1,n,d-1,jD,dp) + maxD;
            finalResult=Math.min(finalResult,result);
        }
        return dp[idx][d]=finalResult;
    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n=jobDifficulty.length;
        if(n<d) return -1;
        int[][] dp=new int[1001][301];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(0,jobDifficulty.length,d,jobDifficulty,dp);
    }
}