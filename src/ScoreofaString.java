public class ScoreofaString {
    public static void main(String[] args) {
        System.out.println(scoreOfString("hello"));
    }
    public static int scoreOfString(String s) {
        int sum=0;
        for(int i=1; i<s.length(); i++){
            sum += Math.abs(s.charAt(i) - s.charAt(i-1));
        }
        return sum;
    }
}
