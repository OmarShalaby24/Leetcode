import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{23,2,4,6,7}, 6));
        System.out.println(checkSubarraySum(new int[]{23,6,9}, 6));
        System.out.println(checkSubarraySum(new int[]{5,0,0,0}, 3));
    }

    public static boolean checkSubarraySum(int[] nums, int k){
        Map<Integer, Integer> reminder = new HashMap<>();
        int sum = 0;
        reminder.put(0, -1);

        for (int i=0; i<nums.length; i++){
            sum += nums[i];
            int remind = sum % k;
            if(reminder.containsKey(remind)){
                if(i-reminder.get(remind) >= 2) return true;
            }
            else
                reminder.put(remind, i);
        }
        return false;
    }
}
