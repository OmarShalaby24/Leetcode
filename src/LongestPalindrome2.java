import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome2 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome("a"));
    }

    public static int longestPalindrome(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            if(!map.containsKey(c)) map.put(c, 1);
            else{
                map.replace(c, map.get(c)+1);
            }
        }

        int result = 0;
        boolean isOdd = false;
        for(Map.Entry<Character, Integer> set: map.entrySet()){
            if(set.getValue()%2 == 0) result += set.getValue();
            else if(set.getValue() == 1) isOdd = true;
            else{
                isOdd = true;
                result += set.getValue() -1;
            }
        }

        return isOdd? result+1: result;
    }
}
