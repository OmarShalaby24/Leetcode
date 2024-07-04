import java.util.Arrays;

public class IntersectionofTwoArraysII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1,2,2,1}, new int[]{2,2})));
        System.out.println(Arrays.toString(intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int c=0;
        int[] res = new int[1000];
        for(int i=0, j=0; i<nums1.length && j<nums2.length;){
            if(nums1[i]> nums2[j]) j++;
            else if(nums1[i]< nums2[j]) i++;
            else{
                res[nums1[i]]++;
                c++;
                i++;
                j++;
            }
        }
        int[] result = new int[c];
        int i=0;
        for(int k=0; k<1000; k++){
            if(res[k] >0 )
                while(res[k]-- > 0)
                    result[i++] = k;
        }
        return result;
    }
}
