class Solution {
    int n;
    int[][] dp;
    public int findLongestChain(int[][] pairs) {
         n = pairs.length;
         dp = new int[n+1][n+1];
         for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
         }
        Arrays.sort(pairs ,(a,b) -> {
            if(a[0]!=b[0]){
                return Integer.compare(a[0],b[0]);
            }

            return Integer.compare(a[1],b[1]);
        });

        return lis(pairs, 0 , -1);
    }

    public int lis(int[][] pairs , int i, int prev) {

        if(i>=n) {
            return 0;
        }

        int take = 0;

        if(prev!=-1 && dp[i][prev]!=-1){
            return dp[i][prev];
        }

        if(prev==-1 || pairs[i][0]>pairs[prev][1]) {
            take = 1 + lis(pairs, i+1, i);
        }

        int skip = lis(pairs,i+1,prev);

        if(prev!=-1) {
            dp[i][prev]=Math.max(take,skip);
        }

        return Math.max(take,skip);
    }
}