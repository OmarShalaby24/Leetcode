import java.util.Stack;

public class MinimumRemovetoMakeValidParentheses {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("))(("));
    }

    public static String minRemoveToMakeValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') stack.push('(');
            else if(s.charAt(i) == ')'){
                if(stack.isEmpty()){
                    s = s.substring(0,i) + s.substring(i+1);
                    i--;
                }
                else stack.pop();
            }
        }
        int count = stack.size();
        if (count==0) return s;
        for(int i=s.length()-1; i>-1; i--){
            if(count>0 && s.charAt(i)=='('){
                s = s.substring(0,i) + s.substring(i+1);
                count--;
            }
        }
        return s;
    }
}
