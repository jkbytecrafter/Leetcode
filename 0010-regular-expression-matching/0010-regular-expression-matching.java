class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return solve(0, 0, s, p, memo);
    }

    private boolean solve(int i, int j, String s, String p, Boolean[][] memo) {
        if (j == p.length()) {
            return i == s.length();
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        boolean firstCharMatched = (i < s.length() && 
                                   (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        boolean result;
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            result = solve(i, j + 2, s, p, memo) || 
                    (firstCharMatched && solve(i + 1, j, s, p, memo));
        } else {
            result = firstCharMatched && solve(i + 1, j + 1, s, p, memo);
        }

        return memo[i][j] = result;
    }
}