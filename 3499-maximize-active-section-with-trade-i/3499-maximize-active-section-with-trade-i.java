class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int curr=0,prev=0,maxOne=0,zeroSeg=0,oneCount=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '0') curr++;
            else if(s.charAt(i) == '1'){
                oneCount++;
                maxOne=Math.max(maxOne,curr+prev);
                if(curr!=0){
                    zeroSeg++;
                    prev=curr;
                }
                curr=0;
            }
       }
       if(curr!=0) zeroSeg++;
       maxOne=Math.max(maxOne,curr+prev);
       return oneCount+((zeroSeg>1) ? maxOne : 0);
    }
}