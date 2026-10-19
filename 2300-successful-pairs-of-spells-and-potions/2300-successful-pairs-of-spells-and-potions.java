class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        Arrays.sort(potions);
        for(int i=0;i<ans.length;i++){
            ans[i] = binarySearch(spells[i], potions, success);
        }
    return ans;
    }
    public int binarySearch(int val, int[] array, long target){
        int ans = -1;
        int start = 0;
        int end = array.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            long curr = ((long)array[mid]) * ((long)val);
            if(curr>=target){
                ans = mid;
                end = mid-1;
            }
            else start = mid + 1;
        }
        if(ans==-1) return 0;
    return array.length-ans;
    }
}