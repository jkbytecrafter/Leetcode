class Solution {
    public String largestGoodInteger(String num) {
        char maxDigit = ' '; 
        for (int i = 2; i < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i - 1) && num.charAt(i - 1) == num.charAt(i - 2)) {
                if (num.charAt(i) > maxDigit) {
                    maxDigit = num.charAt(i);
                }
            }
        }
        if (maxDigit == ' ') {
            return "";
        }
        return String.valueOf(maxDigit).repeat(3);
    }
}