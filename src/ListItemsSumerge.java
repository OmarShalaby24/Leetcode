public class ListItemsSumerge {
    public static void main(String[] args) {
        String[] input1 = {"apple 5 1", "oranges 6 1"};
        String[] input2 = {"bread -1; 1", "milk - 2;1"};
        String[] input3 = {"butter M N", "milk 1 1"};
        String[] input4 = {"cucumber -2 10"};

        System.out.println(total(input1)); // Output: 5+6=11
        System.out.println(total(input2)); // Output: 1+2=3
        System.out.println(total(input3)); // Output: 1=1
        System.out.println(total(input4)); // Output: 20=20
    }

    public static String total(String[] groceryList){
        StringBuilder result = new StringBuilder();
        int finalTotal = 0;

        for(String itemString: groceryList){
            String[] item = itemString.split("[^a-zA-Z0-9]+");
            try{
                if(item.length >= 3){
                    int pricePerUnit = Integer.parseInt(item[item.length-2]);
                    int amountToBuy = Integer.parseInt(item[item.length-1]);
                    int subTotal = pricePerUnit * amountToBuy;
                    result.append(subTotal).append("+");
                    finalTotal += subTotal;
                }
            }catch (NumberFormatException e){
                continue;
            }
        }
        result.deleteCharAt(result.length()-1);
        result.append("=").append(finalTotal);
        return result.toString();
    }
}
