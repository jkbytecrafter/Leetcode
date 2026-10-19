class Solution {
    class Pair{
        int first;
        int second;
        int time;
        public Pair(int first,int second,int time){
            this.first=first;
            this.second=second;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int[][] vis=new int[row][col];
        Queue<Pair> q=new LinkedList<>();
        int cntFresh=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }
                else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1) cntFresh++;
            }
        }
        int  cnt=0,maxTime=0;
        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            int t=q.peek().time;
            q.remove();
            maxTime=Math.max(maxTime,t);
            int []drow={-1,0,1,0};
            int []dcol={0,1,0,-1};
            for(int k=0;k<4;k++){
                int nrow=r+drow[k];
                int ncol=c+dcol[k];
                if( nrow>=0 && nrow<row &&
                    ncol>=0 && ncol<col &&
                    vis[nrow][ncol]!=2 && 
                    grid[nrow][ncol]==1
                ){
                    vis[nrow][ncol]=2;
                    q.add(new Pair(nrow,ncol,t+1));
                    cnt++;
                }
            }
        }
        if(cnt != cntFresh) return -1;
        return maxTime;
    }
}

