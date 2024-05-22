import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

//    public List<List<String>> result = new ArrayList<>();
//    public List<String> part;


    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(s, new ArrayList<>(), result, 0);
        return result;
    }

    public static void dfs(String s, List<String> part, List<List<String>> result, int i){
        if(i >= s.length()) {
            //remove copy form
            result.add(new ArrayList<>(part));
            return;
        }
        for(int j=i; j<s.length(); j++){
            if(isPalindrome(s.substring(i, j+1))) {
                part.add(s.substring(i, j+1));
                dfs(s, part, result, j+1);
                part.remove(part.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s){
        if(s.isEmpty()) return false;
        for(int i=0,j=s.length()-1; i<s.length()/2 && j>i; i++, j--){
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}
