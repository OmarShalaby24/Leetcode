public class MaximumScoreFromRemovingSubstrings {
    public static void main(String[] args) {
        System.out.println(maximumGain("cdbcbbaaabab", 4, 5));
    }

    public static int maximumGain(String s, int x, int y) {
        int as = 0;
        int bs = 0;
        int minScore = Math.min(x, y);
        int result = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == 'a'){
                if(x < y && bs > 0){
                    bs--;
                    result+= y;
                }
                else{
                    as++;
                }
            }
            else if( c == 'b'){
                if(x>y && as > 0){
                    as--;
                    result+= x;
                }
                else{
                    bs++;
                }
            }
            else{
                result += Math.min(as, bs) * minScore;
                as = 0;
                bs = 0;
            }
        }
        result += Math.min(as, bs) * minScore;
        return result;
    }
}
