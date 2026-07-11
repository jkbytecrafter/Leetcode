class Solution {

    private void bfsTraversal(int node, List<Integer>[] adjLs, boolean vis[], int info[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();

            info[0]++; 
            info[1] += adjLs[curr].size(); 

            for (int adjNode : adjLs[curr]) {
                if (!vis[adjNode]) {
                    vis[adjNode] = true;
                    q.add(adjNode);
                }
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {

        List<Integer>[] adjLs = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjLs[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            adjLs[edges[i][0]].add(edges[i][1]);
            adjLs[edges[i][1]].add(edges[i][0]);
        }

        boolean[] visited = new boolean[n];
        int c = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] info = new int[2];
                bfsTraversal(i, adjLs, visited, info);

                if (info[0] * (info[0] - 1) == info[1]) {
                    c++;
                }
            }
        }

        return c;
    }
}