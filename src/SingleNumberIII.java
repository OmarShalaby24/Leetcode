import java.util.Arrays;
import java.util.HashSet;

public class SingleNumberIII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }

    public static int[] singleNumber(int[] nums){
        int[] result = new int[2];
        HashSet<Integer> set = new HashSet<>();

        for(int num: nums){
            if(set.contains(num)){
                set.remove(num);
            }
            else{
                set.add(num);
            }
        }
        int i=0;
        for(int n:set) result[i++] = n;
        return result;
    }
}
