class Solution {
    public int numTilings(int n) {
        final int MOD = 1_000_000_007;

        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        long a = 1;
        long b = 1;
        long c = 2;
        for (int i = 3; i <= n; i++) {
            long d = (2 * c + a) % MOD;
            a = b;
            b = c;
            c = d;
        }
        return (int) c;
    }
}