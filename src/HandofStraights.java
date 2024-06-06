import java.util.Arrays;

public class HandofStraights {
    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3));
        System.out.println(isNStraightHand(new int[]{8,8,9,7,7,7,6,7,10,6}, 2));
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        Arrays.sort(hand);
        int i =0;
        for(;i<hand.length; i++){
            if(hand[i] >= 0 && !findSucessor(hand, groupSize, i)) return false;
        }
        return true;
    }
    public static boolean findSucessor(int[] hand, int groupSize, int i){
        int f = hand[i] +1;
        hand[i] = -1;
        int count = 1;
        i++;

        while (i<hand.length && count < groupSize){
            if(hand[i] == f){
                f = hand[i] +1;
                hand[i] = -1;
                count++;
            }
            i++;
        }
        return count == groupSize;
    }
}
