import java.util.Arrays;
import java.util.HashMap;

public class FirstMissingPositive {
    public static void main(String[] args) {
        Solution s = new Solution();
        runTest(1, new int[]{1,2,4,5}, 3);
        runTest(2, new int[]{2,3,4,5}, 1);
        runTest(3, new int[]{1,2,3,4}, 5);
//        runTest(4, new int[]{1,2,7,8,9,11,12}, 3);
    }
    public static void runTest(int caseNumber, int[] input, int expectedAnswer){
        Solution s = new Solution();
        int solution = s.firstMissingPositive(input);
        System.out.println("Test Case "+caseNumber+" - Output: "+solution+" <"+ (solution==expectedAnswer?"Correct":"Wrong")+">");
    }
}

class Solution{
    public int firstMissingPositive (int[] nums){
        int n=nums.length;
        boolean one = false;
        // 1. Mark the elements which are out of range
        for(int i=0;i<n;i++)
        {
            if(nums[i]==1)
                one = true;
            if(nums[i]<1 || nums[i]>n)
                nums[i]=1;
        }
        if(!one) return 1;
        // 2. Map the element with index : arr[element-1]=0-arr[element-1]
        for(int i=0;i<n;i++)
        {
            int idx = Math.abs(nums[i]);
            nums[idx-1] = -Math.abs(nums[idx-1]); //making the element negative
        }
        // 3. Check which number is not negative i.e. Positive, return its index+1
        for(int i=0;i<n;i++)
        {
            if(nums[i]>0)
                return i+1;
        }
        return n+1;

    }
}
