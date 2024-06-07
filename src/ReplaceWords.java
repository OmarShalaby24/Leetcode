import java.util.ArrayList;
import java.util.List;

public class ReplaceWords {
    public static void main(String[] args) {

        System.out.println(replaceWords(new ArrayList<>(List.of(new String[]{"cat", "bat", "rat"})) , "The cattle was rattled by the battery"));
        System.out.println(replaceWords(new ArrayList<>(List.of(new String[]{"a", "aa", "aaa", "aaaa"})) , "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"));
    }

    public static String replaceWords(List<String> dictionary, String sentence){
        String[] sent = sentence.split(" ");
        for(int i=0; i< sent.length; i++){
            String word = sent[i];
            for (String dic : dictionary) {
                boolean notDerived = false;
                int n = Math.min(dic.length(), word.length());
                for (int k = 0; k < n; k++) {
                    if (word.charAt(k) != dic.charAt(k)) {
                        notDerived = true;
                        break;
                    }
                }
                if (!notDerived && sent[i].length() > dic.length()) sent[i] = dic;
            }
        }

        return String.join(" ", sent);
    }
}
