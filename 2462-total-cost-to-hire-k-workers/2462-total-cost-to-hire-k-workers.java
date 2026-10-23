class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        int n = costs.length;
        int i = 0;
        int j = n - 1;

        while (i < candidates && i <= j) {
            pq1.offer(costs[i++]);
        }

        while (j >= n - candidates && j >= i) {
            pq2.offer(costs[j--]);
        }

        long ans = 0;

        while (k-- > 0) {
            if (pq2.isEmpty() || (!pq1.isEmpty() && pq1.peek() <= pq2.peek())) {
                ans += pq1.poll();

                if (i <= j) {
                    pq1.offer(costs[i++]);
                }
            } else {
                ans += pq2.poll();

                if (i <= j) {
                    pq2.offer(costs[j--]);
                }
            }
        }

        return ans;
    }
}