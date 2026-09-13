class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> a = new ArrayList<>();
        List<int[]> b = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(img1[i][j] == 1) a.add(new int[]{i, j});
                if(img2[i][j] == 1) b.add(new int[]{i, j});
            }
        }
        int count[][] = new int[2 * n][2 * n];
        int result = 0;
        for(int arr[] : a) {
            for(int brr[] : b) {
                int dx = brr[0] - arr[0] + n, dy = brr[1] - arr[1] + n;
                result = Math.max(result, ++count[dx][dy]);
            }
        }
        return result;
    }
}