public class SpecialArrayWithXElementsGreaterThanorEqualX {
    public static void main(String[] args) {
        System.out.println(specialArray(new int[]{0,4,3,0,4}));
    }
    public static int specialArray(int[] nums) {
        int count;
        for(int i=nums.length; i>=0; i--){
            count = 0;
            for(int j=0; j<nums.length; j++){
                if(nums[j] >= i) count++;
            }
            if(i == count) return i;
        }
        return -1;
    }
}
