class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();
        int delete = del(s);
        //System.out.println(delete);
        solve(list, s, 0, s.length() - delete, "");
        return list;
    }
    void solve(List<String> list, String s, int i, int k, String cur){
        
        if(cur.length() == k && valid(cur) && !list.contains(cur)){
            list.add(cur);
            return;
        }
        if(cur.length() + s.length() - i + 1 < k)   return;
        if(i >= s.length() || cur.length() > k)  return;
        //System.out.println(cur);
        if(s.charAt(i) == '(' || s.charAt(i) == ')'){
            solve(list, s, i + 1, k, cur + s.charAt(i));
            solve(list, s, i + 1, k, cur);
        }
        else     solve(list, s, i + 1, k, cur + s.charAt(i));

       

    }
    boolean valid(String s){
        return del(s) == 0;
    }
    int del(String s){
        int n = s.length();

        int count = 0;

        int i=0;int j = n - 1;
        while(i < n){
            if(s.charAt(i) == '(')  break;
            else if(s.charAt(i) == ')') count++;
            i++;
        }

        while(j >= 0){
            if(s.charAt(j) == ')')  break;
            else if(s.charAt(j) == '(') count++;
            j--;
        }
        Stack<Character> st = new Stack<>();
        for(int k = i; k <= j; k++){
            if(s.charAt(k) == ')'){
                if(!st.isEmpty()){
                    char temp = st.pop();
                    if(temp != '('){
                        st.add(temp);
                        st.add(temp);
                    }
                }
                else st.add(')');
            }
            else if(s.charAt(k) == '(') st.add(s.charAt(k));
        }
        return count + st.size();

    }
}