class Solution {
    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] res = new int[col][row];
        if (row == col) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j <= i; j++) {
                    res[j][i] = matrix[i][j];
                    res[i][j] = matrix[j][i];
                }
            }
        } else {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    res[j][i] = matrix[i][j];
                }
            }
        }
        return res;
    }
}