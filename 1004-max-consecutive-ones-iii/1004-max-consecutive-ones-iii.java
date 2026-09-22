class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen=0,len=0,l=0,r=0,zeros=0;
        int leng=nums.length;
        while(r<leng){
            if(nums[r]==0){
                zeros++;
            }
            if(zeros>k){
                if(nums[l]==0){
                    zeros--;    
                }
                l++;
            }
            if(zeros<=k){
                len=r-l+1;
                maxLen=Math.max(maxLen,len);
            }
            r++;

        }
        return maxLen;
    }
}