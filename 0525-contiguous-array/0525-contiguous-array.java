import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> balanceMap = new HashMap<>();
        balanceMap.put(0, -1); // Initialize with balance 0 at index -1
        int maxLength = 0;
        int balance = 0;
        
        for (int i = 0; i < nums.length; i++) {
            balance += nums[i] == 1 ? 1 : -1;
            
            if (balanceMap.containsKey(balance)) {
                maxLength = Math.max(maxLength, i - balanceMap.get(balance));
            } else {
                balanceMap.put(balance, i);
            }
        }
        
        return maxLength;
    }
}