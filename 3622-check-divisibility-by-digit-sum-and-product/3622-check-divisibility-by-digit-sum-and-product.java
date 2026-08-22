class Solution {
    public boolean checkDivisibility(int n) {
        int p=1,s=0,d=0;
        int m=n;
        while(m!=0){
            d=m % 10;
            s+=d;
            p*=d;
            m/=10;
        }
        if( n % (s+p) == 0) return true;
        return false;
    }
}