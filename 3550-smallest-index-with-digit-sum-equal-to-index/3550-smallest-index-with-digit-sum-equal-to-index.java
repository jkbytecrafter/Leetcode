class Solution {
    public int digitSum(int i){
        int s=0;
        while(i!=0){
            s+=(i%10);
            i/=10;
        }
        return s;
    }
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(digitSum(nums[i]) == i ) return i;
        }
        return -1;
    }
}