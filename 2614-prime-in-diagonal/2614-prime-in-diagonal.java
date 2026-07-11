class Solution {
    public boolean isPrime(int num){
        if(num<2) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for(int i=5;i*i<=num;i++){
            if(num%i==0) return false;
        }
        return true;
    }
    public int diagonalPrime(int[][] nums) {
        if(nums.length==0) return 0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int num1=nums[i][i];
            int num2=nums[i][nums.length-1-i];
            boolean b1 = isPrime(num1);
            boolean b2 = isPrime(num2);
            if(isPrime(num1)) 
                ans = Math.max(ans, num1);
            if(isPrime(num2)) 
                ans = Math.max(ans, num2);
        }
        return ans;
    }
}