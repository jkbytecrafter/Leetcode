class Solution {
    public int gcd(int a,int b){
        if(a>b){
            return gcd(a-b,b);
        }
        if(a<b){
            return gcd(b-a,a);
        }
        if(a==0){
            return b;
        }
        return a;

    }
    public int gcdOfOddEvenSums(int n) {
        // int sumEven=0,sumOdd=0,even=2,odd=1;
        // for(int i=1;i<=n;i++){
        //     sumEven+=even;
        //     even+=2;
        //     sumOdd+=odd;
        //     odd+=2;
        // }
        return gcd(n*n,n*(n+1));
    }
}