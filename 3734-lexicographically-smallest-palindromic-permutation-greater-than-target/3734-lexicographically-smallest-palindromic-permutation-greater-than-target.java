class Solution {
    int n;
    String ans = "";
    private boolean solve(StringBuilder sb, int[] hash, String target, int i, boolean greater) {
        if(i == n / 2) {
            StringBuilder half = new StringBuilder(sb);
            half.reverse();
            if(n % 2 != 0) {
                for(int j = 0; j < 26; j++) {
                    if(hash[j] == 1) {
                        sb.append((char)('a' + j));
                    }
                }
            }
            String palindrome = sb.toString() + half.toString();

            if(greater) {
                ans = palindrome;
                return true;
            } else {
                int idx = i;
                while(idx < n) {
                    if(palindrome.charAt(idx) > target.charAt(idx)) {
                        ans = palindrome;
                        return true;
                    }
                    if(palindrome.charAt(idx) < target.charAt(idx)) {
                        if(n % 2 != 0) sb.deleteCharAt(sb.length() - 1);
                        return false;
                    }
                    idx++;
                }
            }
            if(n % 2 != 0) sb.deleteCharAt(sb.length() - 1);
            return false;
        }


        for(char ch = 'a'; ch <= 'z'; ch++) {
            if(hash[ch - 'a'] < 2) continue;

            if(!greater && ch < target.charAt(i)) continue;

            hash[ch - 'a'] -= 2;
            sb.append(ch);
            boolean isGreater = greater || ch > target.charAt(i);

            if(solve(sb, hash, target, i + 1, isGreater)) return true;


             hash[ch - 'a'] += 2;
            sb.deleteCharAt(sb.length() - 1);
        }

        return false;
    }

    public String lexPalindromicPermutation(String s, String target) {
        n = target.length();
        int[] hash = new int[26];
        for(char ch : s.toCharArray()) {
            hash[ch - 'a']++;
        }
        int oddFreqCount = 0;
        for(int val : hash) {
            if(val % 2 != 0) oddFreqCount++;
        }

        if(oddFreqCount > 1) return "";

        solve(new StringBuilder(), hash, target, 0, false);

        return ans;
    }
}
