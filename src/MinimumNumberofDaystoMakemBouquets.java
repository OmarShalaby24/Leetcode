public class MinimumNumberofDaystoMakemBouquets {
    public static void main(String[] args) {
        System.out.println(minDays(new int[]{1,10,3,10,2}, 3, 2));
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        int l = 1, r = 1000000000;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int consecutiveLength = 0, bouquets = 0;
            for (int j : bloomDay) {
                if (j <= mid) {
                    consecutiveLength++;
                    if (consecutiveLength >= k) {
                        consecutiveLength = 0;
                        bouquets++;
                    }
                } else {
                    consecutiveLength = 0;
                }
            }
            if (bouquets >= m) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
