public class SumofAllSubsetXORTotals {
    public static void main(String[] args) {
        
    }
    
    public static int subsetXORSum(int[] nums){
        return dfs(nums, 0, 0);
    }

    public static int dfs(int[] nums, int index, int currentXOR){
        if(nums.length == index) return currentXOR;

        int exclude = dfs(nums, index+1, currentXOR);
        int include = dfs(nums, index+1, currentXOR ^ nums[index]);
        return include + exclude;
    }

}
