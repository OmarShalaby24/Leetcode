public class CountTripletsThatCanFormTwoArraysofEqualXOR {
    public static void main(String[] args) {
        System.out.println(countTriplets(new int[]{2,3,1,6,7})+ " <=> " + 4);
        System.out.println(countTriplets(new int[]{1,1,1,1,1})+ " <=> " + 10);
    }

    public static int countTriplets(int[] arr){
        int count = 0;
        int n = arr.length;

        for(int i=0; i<n; i++){
            int val = arr[i];
            for(int j=i+1; j<n; j++){
                val = val ^ arr[j];

                if(val == 0) count = count + (j-i);
            }
        }
        return count;
    }
}
