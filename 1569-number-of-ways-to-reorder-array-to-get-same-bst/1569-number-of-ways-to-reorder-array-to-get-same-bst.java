class Solution {
    static final long MOD = 1000000007L;
    long[] fact;
    long[] invFact;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        fact = new long[n + 1];
        invFact = new long[n + 1];

        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[n] = power(fact[n], MOD - 2);
        for (int i = n; i >= 1; i--) {
            invFact[i - 1] = invFact[i] * i % MOD;
        }

        List<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(num);
        }

        return (int) ((solve(arr) - 1 + MOD) % MOD);
    }

    long solve(List<Integer> arr) {
        int n = arr.size();
        if (n < 3) {
            return 1;
        }

        int root = arr.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            int num = arr.get(i);
            if (num < root) {
                left.add(num);
            } else {
                right.add(num);
            }
        }

        long choose = fact[n - 1] * invFact[left.size()] % MOD;
        choose = choose * invFact[right.size()] % MOD;

        return choose * solve(left) % MOD
                * solve(right) % MOD;
    }

    long power(long a, long b) {
        long result = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                result = result * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return result;
    }
}