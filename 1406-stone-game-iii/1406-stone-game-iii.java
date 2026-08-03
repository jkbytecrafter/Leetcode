class Solution {
    public String stoneGameIII(int[] stone) {
        int n = stone.length;
        int[] dp = new int[n];
        Arrays.fill(dp , -1);
        int ans = solve(stone , 0 , n , dp);
        if(ans > 0) return "Alice";
        else if(ans < 0) return "Bob";
        else return "Tie";
    }

    private int solve(int[] stone , int i , int n ,int[] dp){
        if(i >= n) return 0;

        if(dp[i] != -1) return dp[i];

        int result = stone[i] - solve(stone , i+1 , n , dp);
        if(i+1 < n){
            result = Math.max(result , stone[i] + stone[i+1] - solve(stone , i+2 , n , dp));
        }

        if(i+2 < n){
            result = Math.max(result , stone[i] + stone[i+1] + stone[i+2] - solve(stone , i+3 , n , dp));
        }
        
        return dp[i] = result;

    }
}