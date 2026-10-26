class Solution {
    public int countIslands(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int sum=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>0){
                    long dum=rec(grid,i,j);
                    
                    if(dum%k==0){
                        sum+=1;
                    }
                }
            }
        }
        return sum;
    }
    static long rec(int[][] arr,int i,int j){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]==0){
            return 0;
        }
        long dum=arr[i][j];
        arr[i][j]=0;
        long d=rec(arr,i+1,j);
        long u=rec(arr,i-1,j);
        long l=rec(arr,i,j-1);
        long r=rec(arr,i,j+1);

        return dum+u+d+l+r;
    }
}