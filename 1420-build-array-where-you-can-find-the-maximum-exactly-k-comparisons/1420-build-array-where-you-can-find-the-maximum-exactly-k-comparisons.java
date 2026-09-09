class Solution {
    public int solve(int idx,int searchCost,int maxSoFar,int n,int m,int k,int[][][] dp){
        int MOD=(int)1e9+7;
        if(idx == n){
            if(searchCost == k) return 1;
            else return 0;
        }
        if(dp[idx][searchCost][maxSoFar] != -1) return dp[idx][searchCost][maxSoFar];
        int result=0;
        for(int i=1 ; i<=m ; i++){
            if(i > maxSoFar){
               result = (result + solve(idx+1,searchCost+1,i,n,m,k,dp)) % MOD;
            }
            else{
                result = (result + solve(idx+1,searchCost,maxSoFar,n,m,k,dp)) % MOD;
            }
        }
        return dp[idx][searchCost][maxSoFar]=result % MOD;
    }
    public int numOfArrays(int n, int m, int k) {
        int[][][] dp=new int[51][51][101];
        for (int[][] row2D : dp) {
            for (int[] row1D : row2D) {
                Arrays.fill(row1D, -1);
            }
        }
        return solve(0,0,0,n,m,k,dp);
    }
}