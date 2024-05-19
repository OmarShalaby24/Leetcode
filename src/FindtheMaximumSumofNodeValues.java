public class FindtheMaximumSumofNodeValues {
    public static void main(String[] args) {
        System.out.println(maximumValueSum(new int[]{1,2,1}, 3, new int[][] {{0,1},{0,2}}));
    }

    public static long maximumValueSum(int[] nums, int k, int[][] edges){
        long sum = 0;
        long minExtra = 1000000;
        int count = 0;

        for( int val : nums) {
            if ((val ^ k) > val ) {
                sum += val ^ k;
                minExtra = Math.min(minExtra, (val ^ k)- val);
                count++;
            } else {
                sum += val;
                minExtra = Math.min(minExtra, val - (val ^ k));
            }
        }

        if ( count %2 ==0 ) {
            return sum;
        } else {
            return sum - minExtra;
        }
    }
}
