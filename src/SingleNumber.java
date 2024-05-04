import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,1}));
    }

    public static int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int j : nums) {
            map.put(j, (map.get(j) == null ? 1 : map.get(j)+1));
        }
        for (int num : nums) {
            if (map.get(num) == 1) return num;
        }
        return -1;
    }
}
