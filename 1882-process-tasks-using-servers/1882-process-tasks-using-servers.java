class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int m = servers.length;
        int n = tasks.length;
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> free = new PriorityQueue<>((a, b) -> {
                if(a[1] == b[1]){
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            });

        for(int i = 0; i < m; i++){
            free.offer(new int[]{i, servers[i]});
        }

        int[] ans = new int[n];
        int time = 0;

        for(int i = 0; i < n; i++){
            time = Math.max(i, time);
            if(free.isEmpty()){
                time = Math.max(time, busy.peek()[0]);
            }

            while(!busy.isEmpty() && busy.peek()[0] <= time){
                int[] currServer = busy.poll();

                free.offer(new int[]{currServer[1], currServer[2]});
            }

            int[] pick = free.poll();

            ans[i] = pick[0];

            busy.offer(new int[]{time + tasks[i], pick[0], pick[1]});
        }
        return ans;
    }
}