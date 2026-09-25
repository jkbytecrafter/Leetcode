class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            mpp.put(arr[i],mpp.getOrDefault(arr[i],0)+1);
        }
        HashSet<Integer> set = new HashSet<>();
        for(int value : mpp.values()){
            if(set.contains(value))
                return false;
            set.add(value);
        }
        return true;
    }
}