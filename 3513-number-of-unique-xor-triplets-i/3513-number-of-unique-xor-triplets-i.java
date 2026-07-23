class Solution {
    public int uniqueXorTriplets(int[] nums) {
        if (nums.length == 1)
            return 1;
        if (nums.length == 2)
            return 2;
        int ans=1;
        while (ans <= nums.length) {
            ans *= 2;
        }
        return ans;
    }
}