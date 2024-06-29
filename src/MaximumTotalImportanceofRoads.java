import java.util.Arrays;


public class MaximumTotalImportanceofRoads {
    public static void main(String[] args) {
        System.out.println(maximumImportance(5, new int[][] {{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}}));
        System.out.println(maximumImportance(5, new int[][] {{0,3},{2,4},{1,3}}));
    }

    public static long maximumImportance(int n, int[][] roads) {
        int cost = 1;
        long[] importance = new long[n];

        for(int[] road: roads){
            importance[road[0]]++;
            importance[road[1]]++;
        }

        Arrays.sort(importance);

        long result = 0;

        for(long imp: importance){
            result += imp * cost++;
        }
        return result;
    }
}
