class Solution {
    public long maxAlternatingSum(int[] nums) {
        long neg = Long.MIN_VALUE / 4;
        long[][] p1 = {{neg, neg}, {neg, neg}};
        long[][] p2 = {{neg, neg}, {neg, neg}};
        long ans = neg;
        for (int v : nums) {
            long x = v;
            long[][] c = new long[2][2];
            c[0][0] = Math.max(x, p1[0][1] + x);
            c[0][1] = p1[0][0] - x;
            c[1][0] = Math.max(p1[1][1] + x, p2[0][1] + x);
            c[1][1] = Math.max(p1[1][0] - x, p2[0][0] - x);
            for (int d = 0; d < 2; d++) {
                for (int s = 0; s < 2; s++) {
                    ans = Math.max(ans, c[d][s]);
                }
            }
            for (int d = 0; d < 2; d++) {
                for (int s = 0; s < 2; s++) {
                    p2[d][s] = p1[d][s];
                    p1[d][s] = c[d][s];
                }
            }
        }
        return ans;
    }
}