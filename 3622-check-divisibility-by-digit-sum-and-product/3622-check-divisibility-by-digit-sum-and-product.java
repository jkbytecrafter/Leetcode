class Solution {
    public boolean checkDivisibility(int n) {
        int p=1,s=0;
        int m=n;
        while(m!=0){
            s+=m % 10;
            p*=m % 10;
            m/=10;
        }
        if( n % (s+p) == 0) return true;
        return false;
    }
}