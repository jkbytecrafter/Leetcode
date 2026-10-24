class Solution {
    public int minFlips(int a, int b, int c) {
        char[] e = convertToBinArr(a);
        char[] f = convertToBinArr(b);
        char[] g = convertToBinArr(c);

        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            char u = e[i], v = f[i], w = g[i];

            cnt += val(u, v, w);
        } 

        return cnt;
    } 

    public static char[] convertToBinArr(int x) {
        char[] arr = new char[32];

        for (int i = 31; i >= 0; i--) {
            arr[i] = (x & 1) == 1 ? '1' : '0';

            x >>>= 1;
        } 

        return arr;
    } 

    public static int val(char u, char v, char w) {
        int cnt = 0;

        if (w == '0') {
            if ((u == '1') && (v == '1')) return 2;
            else if ((u ^ v) == 1) return 1;
            else return 0;
        } else {
            if ((u == '0') && (v == '0')) return 1;
        } 

        return cnt;
    }
}