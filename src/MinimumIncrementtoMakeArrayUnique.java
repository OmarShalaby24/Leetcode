import java.util.Arrays;


public class MinimumIncrementtoMakeArrayUnique {
    public static void main(String[] args) {
        System.out.println(minIncrementForUnique(new int[]{1,2,2}));
        System.out.println(minIncrementForUnique(new int[]{3,2,1,2,1,7}));
    }

    public static int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int counter = 0;

        for(int i=1; i<nums.length; i++){
            if(nums[i] <= nums[i-1]){
                counter+= nums[i-1] - nums[i]+1;
                nums[i] = nums[i-1] +1;
            }
        }
        return counter;
    }
}
