//Easy
public class MakeTheStringGreat {
    public static void main(String[] args) {
        test(1,"leEeetcode", "leetcode");
        test(2,"abBAcC", "");
        test(3,"aBbAcC", "");
        test(4,"abcdDDdCBA", "");
        test(5,"Pp", "");
        test(6,"RLlr", "");

    }
    public static boolean test(int testCase, String s, String expectedOutput){
        boolean flag = makeGood(s).equals(expectedOutput);
        System.out.println("Test Case: "+testCase+" - "+(flag?"Passed":"Failed"));
        return flag;
    }
    public static String makeGood(String s) {
        String result = s;
        for(int i=0; i<s.length();i++){
            if(isCapital(s.charAt(i))){
                //check left
                if(i-1>=0 && s.charAt(i-1) == uncapitalize(s.charAt(i))){
                    s = s.substring(0, i-1) + s.substring(i+1);
                }
                //check right
                else if(i+1<=s.length()-1 && s.charAt(i+1) == uncapitalize(s.charAt(i))){
                    s = s.substring(0, i) + s.substring(i+2);
                }
                if(!result.equals(s)){
                    i=-1;
                    result = s;
                }
            }
        }
        return s;
    }
    public static boolean isCapital(char ch){
        return (int) ch >= 65 && (int) ch <= 90;
    }

    public static char uncapitalize(char ch){
        return !isCapital(ch) ? ch : (char)((int)ch+32);
    }
}
