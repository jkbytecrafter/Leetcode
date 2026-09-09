class Solution {
    public long countCommas(long n) {
        long s = 0;
        if(n < 1000) return 0;
        else if(n >= 1000 && n < (long)Math.pow(10,6)){
            s = (n - (long)Math.pow(10,3) + 1) * 1;
            return s;
        }
        else if(n >= (long)Math.pow(10,6) && n < (long)Math.pow(10,9)){
            s += ((long)Math.pow(10,6) - (long)Math.pow(10,3)) * 1;
            s += (n - (long)Math.pow(10,6) + 1) * 2;
            return s;
        }
        else if(n >= (long)Math.pow(10,9) && n < (long)Math.pow(10,12)){
            s += ((long)Math.pow(10,6) - (long)Math.pow(10,3)) * 1;
            s += ((long)Math.pow(10,9) - (long)Math.pow(10,6)) * 2;
            s += (n - (long)Math.pow(10,9) + 1) * 3;
            return s;
        }
        else if(n >= (long)Math.pow(10,12) && n < (long)Math.pow(10,15)){
            s += ((long)Math.pow(10,6) - (long)Math.pow(10,3)) * 1;
            s += ((long)Math.pow(10,9) - (long)Math.pow(10,6)) * 2;
            s += ((long)Math.pow(10,12) - (long)Math.pow(10,9)) * 3;
            s += (n - (long)Math.pow(10,12) + 1) * 4;
            return s;
        }
        else {
            s += ((long)Math.pow(10,6) - (long)Math.pow(10,3)) * 1;
            s += ((long)Math.pow(10,9) - (long)Math.pow(10,6)) * 2;
            s += ((long)Math.pow(10,12) - (long)Math.pow(10,9)) * 3;
            s += ((long)Math.pow(10,15) - (long)Math.pow(10,12)) * 4;
            s += (n - (long)Math.pow(10,15) + 1) * 5;
            return s;
        }
    }
}