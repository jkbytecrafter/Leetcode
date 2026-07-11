class Solution {
    private ArrayList<Integer> findPrime(int left, int right) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] isPrime = new int[right + 1];
        for (int i = 2; i <= right; i++) {
            isPrime[i] = 1;
        }
        for (int i = 2; i <= Math.sqrt(right); i++) {
            if (isPrime[i] == 1) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = 0;
                }
            }
        }
        for (int i = Math.max(2, left); i <= right; i++) {
            if (isPrime[i] == 1) {
                res.add(i);
            }
        }
        return res;
    }
    public int[] closestPrimes(int left, int right) {
        ArrayList<Integer> primes = findPrime(left, right);
        int[] req = {-1, -1};
        if (primes.size() < 2) {
            return req;
        }
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < primes.size(); i++) {
            int diff = primes.get(i) - primes.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                req[0] = primes.get(i - 1);
                req[1] = primes.get(i);
            }
        }
        return req;
    }
}