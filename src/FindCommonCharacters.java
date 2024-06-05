import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCommonCharacters {

    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"bella","label","roller"}));
        System.out.println(commonChars(new String[]{"cool","lock","cook"}));
    }

    public static List<String> commonChars(String[] words) {
        HashMap<Character, Integer> res = new HashMap<>();
        for(String word : words){
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            for(char c : word.toCharArray()){
                if(!map.containsKey(c)) map.put(c, 0);
                map.replace(c,map.get(c)+1);
            }
            if(word == words[0]) {
                res = map;
                continue;
            }
            HashMap<Character, Integer> newMap = new HashMap<Character, Integer>();;
            for(Map.Entry<Character, Integer> set: map.entrySet()){
                char c = set.getKey();
                if(res.containsKey(c)){
                    newMap.put(c, Math.min(res.get(c), set.getValue()));
                }
            }
            res = newMap;
        }
        List<String> result = new ArrayList<>();
        for(Map.Entry<Character, Integer> set: res.entrySet())
            for(int i=0; i< set.getValue(); i++) result.add(String.valueOf(set.getKey()));
        return result;
    }
}

