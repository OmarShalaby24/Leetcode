import java.util.*;
import java.util.stream.Collectors;

public class RelativeSortArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6})));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2){
        int[] count = new int[1001];
        for(int num: arr1)
            count[num]++;

        int[] result = new int[arr1.length];
        int i=0;

        for(int num: arr2){
            while(count[num] > 0){
                result[i++] = num;
                count[num]--;
            }
        }
        for(int j=0; j< count.length; j++){
            while ((count[j]>0)){
                result[i++] = j;
                count[j]--;
            }
        }
        return result;
    }
}
