class Solution {
    public int solve(String s,int i,int j,int[][] dp){
        if(i>=j) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)) return dp[i][j]=solve(s,i+1,j-1,dp);
        return dp[i][j]=0;
    }
    public String longestPalindrome(String s) {
        int[][] dp=new int[1001][1001];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int len=s.length();
        int maxLen=Integer.MIN_VALUE;
        int sp=0;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(solve(s,i,j,dp) == 1){
                    if(j-i+1>maxLen){
                        maxLen=j-i+1;
                        sp=i;
                    }
                }
            }
        }
        return s.substring(sp,sp+maxLen);
    }
}