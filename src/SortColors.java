import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] rack = new int[]{2,0,2,1,1,0};
        sortColors(rack);
        System.out.println(Arrays.toString(rack));
    }

    public static void sortColors(int[] nums) {
        int[] colors = new int[3];
        for(int ball: nums){
            colors[ball]++;
        }
        int j = 0;
        for(int i=0; i<colors.length; i++){
            for(; colors[i]>0; ){
                nums[j++] = i;
                colors[i]--;
            }
        }
    }
}
