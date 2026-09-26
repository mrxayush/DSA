import java.util.LinkedList;
import java.util.Queue;
class Solution {
    private boolean isValid(int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }
        return true;
    }
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;   
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        if (freshCount == 0) {
            return 0;
        }
        int time = 0;
        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, -1, 1};
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            boolean rottedThisMinute = false;
            for (int s = 0; s < size; s++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                for (int k = 0; k < 4; k++) {
                    int newRow = r + x[k];
                    int newCol = c + y[k];
                    if (isValid(newRow, newCol, n, m) && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2; // Rot the orange
                        queue.offer(new int[]{newRow, newCol}); // Add to queue for next minute
                        freshCount--; // Decrease fresh count
                        rottedThisMinute = true;
                    }
                }
            }
            if (rottedThisMinute) {
                time++;
            }
        }
        return freshCount == 0 ? time : -1;
    }
}