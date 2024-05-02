public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));
        System.out.println(isPalindrome("0P"));
    }

    public static boolean isPalindrome(String s){
        int start =0 , end=s.length()-1;
        s = s.toLowerCase();
        while(start < end){
            if((s.charAt(start) < 97 && (s.charAt(start) < 48 || s.charAt(start) > 57)) || s.charAt(start) > 122){
                start++;
                continue;
            }
            if((s.charAt(end) < 97 && (s.charAt(end) < 48 || s.charAt(end) > 57)) || s.charAt(end) > 122){
                end--;
                continue;
            }
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
