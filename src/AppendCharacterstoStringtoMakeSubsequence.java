public class AppendCharacterstoStringtoMakeSubsequence {
    public static void main(String[] args) {
        System.out.println(appendCharacters("coaching", "coding"));
        System.out.println(appendCharacters("abcde", "a"));
        System.out.println(appendCharacters("z", "abcde"));
        System.out.println(appendCharacters("a", "abcde"));
    }
    
    public static int appendCharacters(String s, String t){
        int i=0, j=0;

        while(i<s.length() && j<t.length()){
            if(s.charAt(i) == t.charAt(j))
                j++;
            i++;
        }
        return t.length()-j;
    }
}
