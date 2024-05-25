import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreakII {
    public static void main(String[] args) {
        String[] arr = new String[]{"cat","cats","and","sand","dog"};
        List<String> dict = Arrays.stream(arr).toList();
        System.out.println(wordBreak("catsanddog", dict));
    }

    static List<String> result;
    static HashSet<String> dict;
    public static List<String> wordBreak(String s, List<String> wordDict){
        result = new ArrayList<>();
        dict = new HashSet<>();
        for(String word: wordDict)
            dict.add(word);
        StringBuilder str = new StringBuilder();
        explore(s, 0, str);
        return result;
    }

    public static void explore(String s, int index, StringBuilder currentString){
        if(index == s.length()) result.add(currentString.toString().trim());
        for(int i=index; i<s.length(); i++){
            if(dict.contains(s.substring(index, i+1))){
                int len = currentString.length();
                currentString.append(s, index, i+1);
                currentString.append(" ");
                explore(s, i+1, currentString);
                currentString.setLength(len);
            }
        }
    }
}
