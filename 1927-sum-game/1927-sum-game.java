class Solution {
    public boolean sumGame(String num) {
        int l=num.length();
        int nql=0,nqr=0,lsum=0,rsum=0;
        for(int i=0;i<l;i++){
            if(i < l/2){
                if(num.charAt(i) == '?') {
                    nql++;
                }
                else{
                    lsum+=(num.charAt(i)) - '0';
                }
            }
            else{
                if(num.charAt(i) == '?') {
                    nqr++;
                }
                else{
                    rsum+=(num.charAt(i)) - '0';
                }
            }
        }
        if((nql+nqr)%2==1) return true;
        if( ((2*rsum)+(9*nqr)) == ((2*lsum)+(9*nql)) ) return false;
        return true;
    }
}