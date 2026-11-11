class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long ans = 0;

        if (costBoth <= cost1 && costBoth <= cost2) {
            ans = 1L * costBoth * Math.max(need1, need2);
        }
        else if (costBoth <= cost2) {
            if (need1 < need2) {
                ans = 1L * costBoth * need2;
            }
            else {
                ans = 1L * costBoth * need2 + 1L * cost1 * (need1 - need2);
            }
        }
        else if (costBoth <= cost1) {
            if (need2 < need1) {
                ans = 1L * costBoth * need1;
            }
            else {
                ans = 1L * costBoth * need1 + 1L * cost2 * (need2 - need1);
            }
        }
        else {
            long temp = 0;

            if (need1 > need2) {
                temp = 1L * costBoth * need2 + 1L * cost1 * (need1 - need2);
            }
            else {
                temp = 1L * costBoth * need1 + 1L * cost2 * (need2 - need1);
            }
            ans = Math.min(1L * cost1 * need1 + 1L * cost2 * need2, temp);
        }

        return ans;
    }
}