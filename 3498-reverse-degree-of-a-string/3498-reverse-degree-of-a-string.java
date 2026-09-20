class Solution {
    public int reverseDegree(String s) {
        int l=s.length();
        int sum=0;
        for(int i=0;i<l;i++){
            char ch=s.charAt(i);
            int j=ch-'a';
            sum+=((i+1)*(26-j));
        }
        return sum;
    }
}