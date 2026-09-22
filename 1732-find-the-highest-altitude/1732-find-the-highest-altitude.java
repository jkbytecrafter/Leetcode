class Solution {
    public int largestAltitude(int[] gain) {
        int n=gain.length;
        int[] alt=new int[n+1];
        alt[0]=0;
        int maxAlt=alt[0];
        for(int i=0;i<n;i++){
            alt[i+1]=alt[i]+gain[i];
            maxAlt=Math.max(maxAlt,alt[i]);
        }
        maxAlt=Math.max(maxAlt,alt[n]);
        return maxAlt;
    }
}