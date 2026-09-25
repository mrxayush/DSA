class Solution {
    
    // 1. Validation function to check if a cell is within grid bounds
    private boolean isValid(int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }
        return true;
    }

    // 2. DFS function to explore all connected land cells of an island
    private void dfs(char[][] grid, int n, int m, int i, int j, boolean[][] visited) {
        // Mark the current cell as visited
        visited[i][j] = true;

        // Direction arrays for Up, Down, Left, Right
        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, -1, 1};

        // Explore all 4 adjacent directions
        for (int k = 0; k < 4; k++) {
            int newRow = i + x[k];
            int newCol = j + y[k];

            // Check if the neighbor is valid, is land ('1'), and is unvisited
            if (isValid(newRow, newCol, n, m) && grid[newRow][newCol] == '1' && !visited[newRow][newCol]) {
                dfs(grid, n, m, newRow, newCol, visited);
            }
        }
    }

    // 3. Main function required by LeetCode
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int islandCount = 0;

        // Scan the entire grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If we find unvisited land ('1')
                if (grid[i][j] == '1' && !visited[i][j]) {
                    // Explore the entire island using DFS
                    dfs(grid, n, m, i, j, visited);
                    // Increment the island count once the DFS traversal completes
                    islandCount++;
                }
            }
        }

        return islandCount;
    }
}