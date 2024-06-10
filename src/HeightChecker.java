import java.util.Arrays;

public class HeightChecker {
    public static void main(String[] args) {
        System.out.println(heightChecker(new int[]{1,1,4,2,1,3}));
    }

    public static int heightChecker(int []heights){
        int[] clone = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights);
        int count = 0;
        for(int i=0; i<heights.length; i++){
            if(heights[i] != clone[i]) count++;
        }
        return count;
    }
}
