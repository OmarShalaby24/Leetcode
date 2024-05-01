public class ReversePrefixOfWord {
    public static void main(String[] args) {
//        System.out.println(reversePrefix("abcdefd", 'd'));
//        System.out.println(reversePrefix("xyxzxe", 'z'));
//        System.out.println(reversePrefix("abcd", 'z'));
        System.out.println(reversePrefix("arzquwnjyn", 'j').equals("jnwuqzrayn"));
    }
    public static String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        int j = word.indexOf(ch);
        if(index == -1) return word;
        char[] result = word.toCharArray();
        for(int i=0; i<index/2+1; i++){
            // if(i>=index) break;
            char temp = result[i];
            result[i] = result[j];
            result[j] = temp;
            j--;
        }
        word = String.valueOf(result);
        return word;
    }
}
