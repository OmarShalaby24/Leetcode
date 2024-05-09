import java.util.Arrays;

public class MaximizeHappinessOfSelectedChildren {
    public static void main(String[] args) {
        System.out.println(maximumHappinessSum(new int[]{1,2,3}, 2));
    }

    public static long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long res = 0;
        int n = happiness.length, j = 0;

        for (int i = n - 1; i >= n - k; --i) {
            happiness[i] = Math.max(happiness[i] - j++, 0);
            res += happiness[i];
        }

        return res;
    }
}
