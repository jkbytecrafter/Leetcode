class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] mpp=new int[26];
        for(char ch:chars.toCharArray()){
            mpp[ch-'a']++;
        }
        int l=0;
        for(String s:words){
            boolean form=true;
            int[] mpp_word=new int[26];
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                mpp_word[c-'a']++;
                 if(mpp[c-'a'] < mpp_word[c-'a']){
                    form=false;
                    break;
                 }
            }
            if(form) l+=s.length();
        }
        return l;
    }
}