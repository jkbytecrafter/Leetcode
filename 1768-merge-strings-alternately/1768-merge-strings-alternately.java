class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb=new StringBuilder();
        int l1=word1.length();
        int l2=word2.length();
        int i=0,j=0;
        while(i<l1 && j<l2){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));
            i++;j++;
        }
        if(i<=l1-1) sb.append(word1.substring(i));
        if(j<=l2-1) sb.append(word2.substring(j));
        return sb.toString();
    }
}