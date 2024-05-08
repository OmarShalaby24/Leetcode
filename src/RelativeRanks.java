import java.util.Arrays;

public class RelativeRanks {
    public static void main(String[] args) {
//        int[] score = new int[]{5,4,3,2,1};
        int[] score = new int[]{123123,11921,1,0,123};
        System.out.println(Arrays.toString(findRelativeRanks(score)));
    }
    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];
        String[] medals = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};
        for(int i=0; i<n; i++){
            int mi = findMaxIndex(score);
            score[mi] = -1;
            if(i<3)
                result[mi] = medals[i];
            else
                result[mi] = Integer.toString(i+1);
        }

        return result;
    }

    public static int findMaxIndex(int[] score){
        int max = -1;
        int index = -1;
        for(int i=0 ;i<score.length ; i++){
            if(score[i]>=max) {
                max = score[i];
                index = i;
            }
        }
        return index;
    }
}
