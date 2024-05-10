import java.util.*;

public class KthSmallestPrimeFraction {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3)));
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1, 7}, 1)));
    }

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingDouble(fraction -> {
            int[] index = fraction;
            return (double) arr[index[0]] / arr[index[1]];
        }));

        // Initialize the priority queue with the fractions formed by the first element and subsequent prime numbers
        for (int j = 1; j < arr.length; j++) {
            pq.offer(new int[]{0, j});
        }

        // Extract the smallest fraction k times
        for (int i = 0; i < k - 1; i++) {
            int[] fraction = pq.poll();
            int numeratorIndex = fraction[0];
            int denominatorIndex = fraction[1];

            if (numeratorIndex + 1 < denominatorIndex) {
                pq.offer(new int[]{numeratorIndex + 1, denominatorIndex});
            }
        }

        int[] result = pq.poll();
        return new int[]{arr[result[0]], arr[result[1]]};
    }
}
