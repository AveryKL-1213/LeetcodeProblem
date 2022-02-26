public class ShortestPathVisitingAllNodes {
    public static void main(String[] args) {
        int[][] graph = {{1, 2, 3}, {0}, {0}, {0}};
        int ans = shortestPathLength(graph);
        System.out.println(ans);
    }

    public static int shortestPathLength(int[][] graph) {
        int len = graph.length;
        int endMask = (1 << len) - 1;
        int[][] cache = new int[len + 1][endMask + 1];

        int best = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            best = Math.min(best, dp(i, endMask, graph, cache));
        }
        return best;
    }

    public static int dp(int node, int mask, int[][] graph, int[][] cache) {
        if (cache[node][mask] != 0) {
            return cache[node][mask];
        }
        if ((mask & (mask - 1)) == 0) {
            return 0;
        }
        cache[node][mask] = Integer.MAX_VALUE - 1;
        for (int neighbour : graph[node]) {
            if ((mask & (1 << neighbour)) != 0) {
                int visitedBest = dp(neighbour, mask, graph, cache);
                int didNotVisitedBest = dp(neighbour, mask ^ (1 << node), graph, cache);
                int better = Math.min(visitedBest, didNotVisitedBest);
                cache[node][mask] = Math.min(cache[node][mask], 1 + better);
            }
        }
        return cache[node][mask];
    }
}
