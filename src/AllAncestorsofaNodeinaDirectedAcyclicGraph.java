import java.util.*;

public class AllAncestorsofaNodeinaDirectedAcyclicGraph {
    public static void main(String[] args) {
        System.out.println(getAncestors(8, new int[][]{{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}}));
        System.out.println(getAncestors(6, new int[][]{{0,3},{5,0},{2,3},{4,3},{5,3},{1,3},{2,5},{0,1},{4,5},{4,2},{4,0},{2,1},{5,1}}));
    }

    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> dc = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>());
            dc.add(new ArrayList<>());
        }
        for (int[] e: edges)
            dc.get(e[0]).add(e[1]);
        for (int i = 0; i < n; i++)
            dfs(i, i, ans, dc);
        return ans;

    }
    private static void dfs(int x, int curr, List<List<Integer>> ans, List<List<Integer>> dc) {
        for (int ch: dc.get(curr))
            if(ans.get(ch).isEmpty() || ans.get(ch).get(ans.get(ch).size() - 1) != x) {
                ans.get(ch).add(x);
                dfs(x, ch, ans, dc);
            }
    }
}
