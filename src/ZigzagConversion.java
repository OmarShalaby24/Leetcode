import java.util.Arrays;
import java.util.HashMap;

public class ZigzagConversion {
    public static void main(String[] args) {
//        System.out.println(convert("PAYPALISHIRING", 3) + " Expected: PAHNAPLSIIGYIR");
//        System.out.println(convert("PAYPALISHIRING", 4));
        System.out.println(convert("AB", 1));
    }
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        HashMap<Integer, String> map = new HashMap<>();
        int[] row = new int[s.length()];
        int itr = 1;
        boolean down = true;
        for(int i=0; i<s.length(); i++){
            row[i] = itr;
            if (down) {
                if(itr == numRows){
                    itr--;
                    down = false;
                    continue;
                }
                itr++;
            }
            else  {
                if(itr == 1){
                    itr++;
                    down = true;
                    continue;
                }
                itr--;
            }
        }
        for(int i=1; i<numRows+1; i++){
            map.put(i, "");
        }
        for(int i=0;i<s.length();i++){
            map.put(row[i], map.get(row[i])+s.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        for(int i=1; i<numRows+1; i++){
            result.append(map.get(i));
        }
        return result.toString();
    }
}
