class Solution {
    public boolean uniformArray(int[] nums1) {
        int n= nums1.length;
        int odd=0,even=0,min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(nums1[i] % 2 == 0) even++;
            else odd++;
            if(min > nums1[i]) min = nums1[i];
        }
        if(odd == n || even == n)  return true;
        if(min%2==1) return true;
        return false;
    }
}