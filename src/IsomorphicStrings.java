import java.util.HashMap;

public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
    }

    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char index1 = s.charAt(i) , index2 = t.charAt(i);
            if(map1.containsKey(index1) && map2.containsKey(index2)){
                if(!map1.get(index1).equals(map2.get(index2))) return false;
            }
            else if (!map1.containsKey(index1) && !map2.containsKey(index2)){
                map1.put(index1, map1.size());
                map2.put(index2, map2.size());
            }
            else return false;
        }
        return true;
    }
}
