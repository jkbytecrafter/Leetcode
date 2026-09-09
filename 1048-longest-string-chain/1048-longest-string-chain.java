class Solution {
    public boolean checkOrder(String s,String t){
        if (s == null || t == null) {
            return false;
        }
        if (t.length() != s.length() + 1) {
            return false;
        }
        int prevPointer = 0;
        int currPointer = 0;

        while (prevPointer < s.length() && currPointer < t.length()) {
            if (s.charAt(prevPointer) == t.charAt(currPointer)) {
                prevPointer++;
            }
            currPointer++;
        }
        return prevPointer == s.length();
    }
    public int solve(String[] words,int i,int p,int[][] dp){
        if(i >= words.length) return 0;
        if(dp[i][p+1] != -1) return dp[i][p+1];
        int take=0,skip=0;
        if(p==-1 || ((words[i].length() - words[p].length()==1) && checkOrder(words[p],words[i]))) 
            take=solve(words,i+1,i,dp) + 1;
        skip=solve(words,i+1,p,dp);
        return dp[i][p+1]=Math.max(take,skip);
    }
    public int longestStrChain(String[] words) {
        int n=words.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        return solve(words ,0,-1, dp);
    }
}