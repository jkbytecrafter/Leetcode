class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long lS = 0;
        long min = Long.MAX_VALUE;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            lS += nums[i];
            long rS = sum - lS;
            long lAvg = lS / (i + 1);
            long rAvg = 0;
            if (n - i - 1 > 0) {
                rAvg = rS / (n - i - 1);
            }
            long diff = Math.abs(lAvg - rAvg);
            if (diff < min) {
                min = diff;
                idx = i;
            }
        }

        return idx;
    }
}