class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int[] i : grid) {
            String s = Arrays.toString(i);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int[] col = new int[n];
            for (int j = 0; j < n; j++)
                col[j] = grid[j][i];

            String s = Arrays.toString(col);

            if (map.containsKey(s))
                ans += map.get(s);
        }

        return ans;
    }
}