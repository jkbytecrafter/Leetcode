class Solution {
    public boolean sumGame(String num) {
        int l=num.length();
        int nq=0;
        for(int i=0;i<l;i++){
            if(num.charAt(i) == '?') nq++;
        }
        if(nq%2==1) return true;
        String firstHalf=num.substring(0,(l/2));
        String secondHalf=num.substring((l/2),l);
        int nql=0,nqr=0,lsum=0,rsum=0;
        for(int i=0;i<firstHalf.length();i++){
            if(firstHalf.charAt(i) == '?') {
                nql++;
            }
            else{
                lsum+=(firstHalf.charAt(i)) - '0';
            }
        }
        for(int i=0;i<secondHalf.length();i++){
            if(secondHalf.charAt(i) == '?') {
                nqr++;
            }
            else{
                rsum+=(secondHalf.charAt(i)) - '0';
            }
        }
        if( ((2*rsum)+(9*nqr)) == ((2*lsum)+(9*nql)) ) return false;
        return true;
    }
}