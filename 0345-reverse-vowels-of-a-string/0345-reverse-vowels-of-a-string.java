class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            if( ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U' ||
                ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' ) sb.append(ch);
        }
        StringBuilder snew=new StringBuilder();
        int x=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if( ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U' ||
                ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' ) snew.append(sb.charAt(x++));
            else 
                snew.append(ch);
        }
        return snew.toString();
    }
}