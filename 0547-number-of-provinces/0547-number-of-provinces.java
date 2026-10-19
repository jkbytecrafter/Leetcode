class Solution {
    private void bfs(int node, int[][] adj, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int j = 0; j < adj.length; j++) {
                if (adj[curr][j] == 1 && !vis[j]) {
                    vis[j] = true;
                    q.add(j);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, isConnected, visited);
                count++;  
            }
        }

        return count;
    }
}