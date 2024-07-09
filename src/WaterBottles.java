public class WaterBottles {
    public static void main(String[] args) {
        System.out.println(numWaterBottles(15, 8));
        System.out.println(numWaterBottles(15, 4));
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;
        int remainder = 0;
        while(numBottles >= numExchange){
            result += numBottles / numExchange;
            numBottles = (numBottles / numExchange) + (numBottles % numExchange);
        }
        return result;
    }
}
