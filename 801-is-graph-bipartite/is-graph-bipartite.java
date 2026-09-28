import java.util.Arrays;

class Solution {
    private boolean isBipartite = true;

    // DFS function to color the graph and check for contradictions
    private void dfs(int node, int col, int[][] graph, int[] colors) {
        colors[node] = col;

        for (int neighbor : graph[node]) {
            // If the neighbor is not yet colored, color it with the opposite color
            if (colors[neighbor] == -1) {
                dfs(neighbor, 1 - col, graph, colors);
                if (!isBipartite) return;
            } 
            // If the neighbor is already colored with the same color, it's not bipartite
            else if (colors[neighbor] == col) {
                isBipartite = false;
                return;
            }
        }
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1); // -1 means uncolored

        isBipartite = true; // Reset for test cases

        // Handle multiple components in the graph
        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                // Start DFS with color 0
                dfs(i, 0, graph, colors);
                if (!isBipartite) {
                    return false;
                }
            }
        }

        return true;
    }
}