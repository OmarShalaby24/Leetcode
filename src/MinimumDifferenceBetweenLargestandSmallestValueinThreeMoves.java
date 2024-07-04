import java.util.Arrays;

public class MinimumDifferenceBetweenLargestandSmallestValueinThreeMoves {
    public static void main(String[] args) {
        System.out.println(minDifference(new int[]{2,3,4,5}));
        System.out.println(minDifference(new int[]{5,3,2,4}));
        System.out.println(minDifference(new int[]{1,5,0,10,14}));
        System.out.println(minDifference(new int[]{3,100,20}));
        System.out.println(minDifference(new int[]{53,60,100,85,16,68,64,31,37,78}));
        System.out.println(minDifference(new int[]{6,6,0,1,1,4,6}));
        System.out.println(minDifference(new int[]{0,1,5,10,14}));
    }

    public static int minDifference(int[] nums){
        if (nums.length <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int k = nums.length - 3;
        int ans = nums[nums.length - 1] - nums[0];
        for (int i = k - 1; i < nums.length; i++) {
            ans = Math.min(ans, nums[i] - nums[i - k + 1]);
        }
        return ans;
    }
}
