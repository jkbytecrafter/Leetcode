class Solution {
    public int numSpecial(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int result=0;
        int[] rowArr=new int[n];
        int[] colArr=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    rowArr[i]++;
                    colArr[j]++;
                }
            }
        }    
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                //if(mat[i][j]==0) continue;
                if(mat[i][j]==1){
                    if(rowArr[i]==1 && colArr[j]==1){
                        result++;
                    }
                }
            }
        }      
        return result;
    }
}