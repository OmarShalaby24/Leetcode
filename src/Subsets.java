import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }

    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, new ArrayList<>(), result, 0);
        return result;
    }

    public static void dfs(int[] nums, List<Integer> set,List<List<Integer>> result, int index){
        if(index >= nums.length){
            result.add(new ArrayList<>(set));
            return;
        }
        dfs(nums, new ArrayList<>(set), result, index+1);
        List<Integer> subset = new ArrayList<>(set);
        subset.add(nums[index]);
        dfs(nums, new ArrayList<>(subset), result, index+1);
    }
}
