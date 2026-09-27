class Solution {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for (char ch : arr) {
            if (ch == '(') {
                stack.add(sb.toString());
                sb = new StringBuilder();
            } else if (ch == ')') {
                sb.reverse();
                if (!stack.isEmpty()) {
                    sb = new StringBuilder(stack.pop()).append(sb);
                }
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}