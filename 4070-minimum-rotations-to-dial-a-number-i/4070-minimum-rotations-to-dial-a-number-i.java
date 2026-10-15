class Solution {
    public int minRotations(String s) {
        int totalRotations = 0;
        int current = 0;
        for (char ch : s.toCharArray()) {
            int target = ch - '0';
            int diff = Math.abs(current - target);
            totalRotations += Math.min(diff, 10 - diff);
            current = target;
        }
        return totalRotations;
    }
}