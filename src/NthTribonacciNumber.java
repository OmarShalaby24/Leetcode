import java.util.*;

public class NthTribonacciNumber {
    public static void main(String[] args) {
        System.out.println(tribonacci(4));
        System.out.println(tribonacci(25));
    }

    public static int tribonacci(int n) {
        if (n == 0) return 0;
        else if (n == 1 || n == 2) return 1;
        int x = 3;
        int[] memory = new int[n+1];
        memory[0] = 0;
        memory[1] = 1;
        memory[2] = 1;
        while(x <= n){
            memory[x] = memory[x-1] + memory[x-3] + memory[x-2];
            x++;
        }
        return memory[n];
    }
}
