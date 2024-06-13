import java.util.Arrays;

public class MinimumNumberofMovestoSeatEveryone {
    public static void main(String[] args) {
        System.out.println(minMovesToSeat(new int[]{3,1,5}, new int[]{2,7,4}));
        System.out.println(minMovesToSeat(new int[]{4,1,5,9}, new int[]{1,3,2,6}));
        System.out.println(minMovesToSeat(new int[]{2,2,6,6}, new int[]{1,3,2,6}));
    }

    public static int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int sum=0;
        for(int i=0; i<seats.length; i++)
        {
            sum += Math.abs(seats[i] - students[i]);
        }
        return sum;
    }
}


