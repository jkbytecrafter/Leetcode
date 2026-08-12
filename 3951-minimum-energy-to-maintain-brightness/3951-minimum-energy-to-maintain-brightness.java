class Solution {
    public long minEnergy(int n, int brightness, int[][] intervals) {
        if (brightness <= 0 || intervals == null || intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals,(a,b) -> {
            if(a[0]!=b[0]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[1],b[1]);
        });

        int cE=intervals[0][1];
        int cS=intervals[0][0];
        long count=0;
        
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]<=cE){
                cE=Math.max(intervals[i][1],cE);
            }else{
                count+=(cE-cS+1);
                cS = intervals[i][0];
                cE = intervals[i][1];
            }
        }
        count+=(cE-cS+1);
        long no_of_bulb = (brightness+2)/3;
        if(no_of_bulb>n){
            no_of_bulb=n;
        }
        return (long)count * no_of_bulb;
    }
}