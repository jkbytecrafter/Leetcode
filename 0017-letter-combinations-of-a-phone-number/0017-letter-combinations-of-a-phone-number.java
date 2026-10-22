class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        String[] phone = {
            "", "", "abc", "def", "ghi", "jkl", 
            "mno", "pqrs", "tuv", "wxyz"
        };
        
        List<String> result = new ArrayList<>();
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            List<String> tempList = new ArrayList<>();
            String letters = phone[digits.charAt(i) - '0'];
            for (String c : result) {
                for (char l : letters.toCharArray()) {
                    tempList.add(c + l); 
                }
            }
            result = tempList; 
        }
        
        return result;
    }
}