import java.util.*;

public class FindTheSafestPathInGrid {
    public static void main(String[] args) {
        Solution_1 sol = new Solution_1();
        System.out.println(sol.maximumSafenessFactor(new int[][] {{0,0,1},{0,0,0},{0,0,0}}));
//        System.out.println(Arrays.toString(getIndex(2, 3)));
    }
}
class Solution_1 {
    static int[] x = new int[]{0, 1, 0, -1}, y = new int[]{1, 0, -1, 0};

    public int maximumSafenessFactor(int[][] grid) {
        int N = grid.length, M = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            for (int k = 0; k < 4; k++) {
                int r2 = r + x[k], c2 = c + y[k];
                if (r2 >= 0 && r2 < N && c2 >= 0 && c2 < M) {
                    if (dist[r2][c2] == -1) {
                        dist[r2][c2] = dist[r][c] + 1;
                        q.offer(new int[]{r2, c2});
                    }
                }
            }
        }
        return search(dist, 0, N + M);
    }
    public boolean check(int[][] dist, int K) {
        if (dist[0][0] < K) return false;
        int N = dist.length, M = dist[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        boolean[][] vis = new boolean[N][M];
        vis[0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            for (int k = 0; k < 4; k++) {
                int r2 = r + x[k], c2 = c + y[k];
                if (r2 >= 0 && r2 < N && c2 >= 0 && c2 < M) {
                    if (!vis[r2][c2] && dist[r2][c2] >= K) {
                        vis[r2][c2] = true;
                        q.offer(new int[]{r2, c2});
                    }
                }
            }
        }
        return vis[N - 1][M - 1];
    }
    public int search(int[][] dist, int l, int r) {
        if (l > r) return -1;
        int mid = (l + r) / 2;
        if (check(dist, mid)) {
            int m = search(dist, mid + 1, r);
            if (m == -1) return mid;
            return m;
        }
        return search(dist, l, mid - 1);
    }
}
