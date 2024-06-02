public class ReverseString {
    public static void main(String[] args) {
        char[] s = new char[]{'h','e','l','l','o'};
        reverseString(s);
        System.out.println(s);
    }

    public static void reverseString(char[] s) {
        int i =0;
        int j = s.length-1;
        while(i<j){
            char c = s[i];
            s[i++] = s[j];
            s[j--] = c;
        }
    }
}
