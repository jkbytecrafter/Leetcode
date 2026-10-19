class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]] = '+';

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int steps = current[2];

            for (int[] dir : directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n ||
                    maze[nr][nc] == '+') {
                    continue;
                }

                if (nr == 0 || nr == m - 1 || nc == 0 || nc == n - 1) {
                    return steps + 1;
                }

                maze[nr][nc] = '+';
                queue.offer(new int[]{nr, nc, steps + 1});
            }
        }

        return -1;
    }
}