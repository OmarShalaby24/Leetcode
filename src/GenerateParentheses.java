import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n, n-1, n, "(", result);
        return result;
    }

    public static String generate(int n, int open, int close,  String str, List<String> results){
        String caseOneString;
        String caseTwoString;
        if(open==0 && close==0) {
//            results.add(str);
            return str;
        };
        if(open>0){
            caseOneString = generate(n, open-1, close, str+"(", results);
            if (caseOneString.length() == 2*n) results.add(caseOneString);
        }
        if(close>0 && close>open){
            caseTwoString = generate(n, open, close-1, str+")", results);
            if (caseTwoString.length() == 2*n) results.add(caseTwoString);
        }
        if(str.length() == 2*n){
            results.add(str);
        }
        return str;
    }
}
