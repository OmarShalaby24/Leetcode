public class SumofSquareNumbers {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(2147483600));
    }

    public static boolean judgeSquareSum(int c) {
        long i = 0;
        long j = (long)Math.sqrt(c);
        while(i<=j){
            long p = i*i + j*j ;
            if(p == c) return true;
            if(p > c){
                j--;
            }
            else{
                i++;
            }
        }
        return false;
    }
}
