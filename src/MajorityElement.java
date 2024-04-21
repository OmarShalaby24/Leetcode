import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        int result = 0;
        for(int x : nums){
            if(map.containsKey(x)){
                map.replace(x, map.get(x)+1);
            }
            else{
                map.put(x, 1);
            }
            if(max < map.get(x)){
                max = map.get(x);
                result = x;
            }
        }
        return result;
    }
}
