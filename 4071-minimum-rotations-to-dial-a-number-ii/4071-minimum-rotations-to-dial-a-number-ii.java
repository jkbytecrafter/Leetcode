class Solution {
    public int minRotations(int n, String s) {
        long[] p = new long[n];
        int d0 = Math.abs(s.charAt(0) - '0');
        p[0] = Math.min(d0, 10 - d0);
        for (int i = 1; i < n; ++i) {
            int d = Math.abs(s.charAt(i) - s.charAt(i-1));
            p[i] = p[i-1] + Math.min(d, 10 - d);
        }
        long minCost = p[n-1];
        for (int k = 0; k < n; ++k) {
            char prev = (k == 0) ? '0' : s.charAt(k-1);
            long prefix = (k == 0) ? 0 : p[k-1];
            int dist = Math.abs(s.charAt(n-1) - prev);
            long transitionCost = Math.min(dist, 10 - dist);
            long internal = p[n-1] - p[k];
            long totalCost = prefix + transitionCost + internal;
            minCost = Math.min(minCost, totalCost);
        }
        return (int) minCost;
    }
}