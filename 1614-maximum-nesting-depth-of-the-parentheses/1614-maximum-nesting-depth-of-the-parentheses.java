class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));

                if (depth < stack.size()) {
                    depth = stack.size();
                }
            }
            else if (s.charAt(i) == ')') {
                stack.pop();
            }
        }

        return depth;
    }
}