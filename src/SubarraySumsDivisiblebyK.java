import java.util.HashMap;

public class SubarraySumsDivisiblebyK {
    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5));
    }

    public static int subarraysDivByK(int[] nums, int k) {
        int count =0;
        int prefixSum = 0;
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);

        for(int num: nums){
            prefixSum += num;

            int mod = prefixSum % k;
            if(mod < 0)
                mod += k;
            if(prefixMap.containsKey(mod)){
                count += prefixMap.get(mod);
                prefixMap.put(mod, prefixMap.get(mod)+1);
            }
            else{
                prefixMap.put(mod, 1);
            }
        }
        return count;
    }
}
