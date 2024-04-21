import java.util.*;

public class FindIfPathExistsInGraph {
    public static void main(String[] args) {
        int [][] edges = new int[][] {{4,3},{1,4},{4,8},{1,7},{6,4},{4,2},{7,4},{4,0},{0,9},{5,4}};

        System.out.println(validPath(10, edges, 0 ,2));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        Set<Integer> visited = new HashSet<>();
        return dfs(source, destination, graph, visited);
    }
    public static boolean dfs(int node, int destination, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if (node == destination) {
            return true;
        }
        visited.add(node);
        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                if (dfs(neighbor, destination, graph, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
