class Solution {
    final int MOD = 1000000007;

    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[][][] dp = new long[m][n][2];
        dp[0][0][0] = grid[0][0];
        dp[0][0][1] = grid[0][0];
        for (int j = 1; j < n; j++) {
            dp[0][j][0] = dp[0][j - 1][0] * grid[0][j];
            dp[0][j][1] = dp[0][j - 1][1] * grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0][0] = dp[i - 1][0][0] * grid[i][0];
            dp[i][0][1] = dp[i - 1][0][1] * grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long upMax = dp[i - 1][j][0];
                long upMin = dp[i - 1][j][1];
                long leftMax = dp[i][j - 1][0];
                long leftMin = dp[i][j - 1][1];
                long val = grid[i][j];

                dp[i][j][0] = Math.max(
                    Math.max(upMax * val, upMin * val), 
                    Math.max(leftMax * val, leftMin * val)
                );
                
                dp[i][j][1] = Math.min(
                    Math.min(upMax * val, upMin * val), 
                    Math.min(leftMax * val, leftMin * val)
                );
            }
        }
        long maxProd = dp[m - 1][n - 1][0];
        return maxProd < 0 ? -1 : (int) (maxProd % MOD);
    }
}