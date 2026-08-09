class Solution {
    public boolean solve(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }

        boolean first_char_matched = s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*') {
            boolean not_take = solve(s, p.substring(2));
            boolean take = first_char_matched && solve(s.substring(1), p);
            return not_take || take;
        }

        return first_char_matched && solve(s.substring(1), p.substring(1));
    }

    public boolean isMatch(String s, String p) {
        return solve(s, p);
    }
}