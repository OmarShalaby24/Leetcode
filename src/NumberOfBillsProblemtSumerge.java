import java.util.Arrays;

public class NumberOfBillsProblemtSumerge {
    public static void main(String[] args) {

//        System.out.println(numberOfBills(new Integer[]{0,3,1,1,1}, new String[]{"5","10","20","50","100"}, 70));
//        System.out.println(numberOfBills(new int[]{0,3,1,1,1}, new int[]{5,10,20,50,100}, 70));
        System.out.println(numberOfBills(new int[]{100,432,0,3,1,1,1,5,4}, new int[]{1,2,5,10,20,50,100,200,500}, 100));
        System.out.println(numberOfBills(new int[]{100,432,0,3,1,1,1,5,4}, new int[]{1,2,5,10,20,50,100,200,500}, 95));

    }

    public static String numberOfBills(int[] billCount, int[] billValue, int withdrawAmount){
        StringBuilder result = new StringBuilder();
        int n = billValue.length;
        Integer[] indices = new Integer[n];
        for(int i=0; i<n; i++) indices[i] = i;
        Arrays.sort(indices, (i, j) -> Integer.compare(billValue[j], billValue[i]));

        for(int i : indices){
            int billV = billValue[i];
            int billC = billCount[i];

            int dispenseCount = Math.min(withdrawAmount / billV, billC);
            if(dispenseCount > 0){
                result.append(billV).append("x").append(dispenseCount).append(",");
                withdrawAmount = withdrawAmount - dispenseCount*billV;
            }
            if(withdrawAmount == 0) break;
        }
        if(withdrawAmount != 0 )return "-1";
        result.deleteCharAt(result.length()-1);

        return result.toString();
    }
}
