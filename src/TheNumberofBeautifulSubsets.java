import java.util.*;

public class TheNumberofBeautifulSubsets {
    public static void main(String[] args) {
        System.out.println(beautifulSubsets(new int[]{2,4,6}, 2));
        System.out.println(beautifulSubsets(new int[]{1000,999,998,997,996,995,994,993,992,991}, 1));
    }
    private static int count = 0;
    private static Map<Integer, Integer> visited = new HashMap<>();

    public static int beautifulSubsets(int[] nums, int k) {
        explore(nums, k, 0);
        return count - 1;
    }

    private static void explore(int[] nums, int k, int index) {
        if (index == nums.length) {
            count++;
            return;
        }

        int num = nums[index];

        if (!visited.containsKey(num - k) && !visited.containsKey(num + k)) {
            visited.put(num, visited.getOrDefault(num, 0) + 1);
            explore(nums, k, index + 1);
            visited.put(num, visited.get(num) - 1);
            if (visited.get(num) == 0) {
                visited.remove(num);
            }
        }

        explore(nums, k, index + 1);
    }
}
