class Solution {
    public boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') return true;
        return false;
    }
    public int maxVowels(String s, int k) {
        int ans=0;
        for(int i=0;i<k;i++){
            char ch=s.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') ans++;
        }
        if(s.length()==k) return ans;
        int vc=ans;
        ans=vc;
        for(int i=k;i<s.length();i++){
            if(isVowel(s.charAt(i-k)) == true) vc--;
            if(isVowel(s.charAt(i)) == true) vc++;
            ans=Math.max(ans,vc);
        }
        return ans;
    }
}