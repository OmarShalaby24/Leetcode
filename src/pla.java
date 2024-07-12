public class pla {
    public static void main(String[] args) {
        System.out.println(palindrome("Madam"));
        System.out.println(palindrome("race a car"));

    }

    public static boolean palindrome(String str){
        str = str.toLowerCase();
        if(str.length() <=1) return true;
        char x = str.charAt(0);
        char y = str.charAt(str.length()-1);

        if(x < 'a' || x > 'z'){
            return palindrome(str.substring(1));
        }
        else if (y < 'a' || y > 'z') {
            return palindrome(str.substring(0, str.length()-1));
        }
        if( x != y) return false;
        return palindrome(str.substring(1, str.length()-1));
//        int i =0, j=str.length()-1;
//        str = str.toLowerCase();
//
//        while(i<= j){
//            if(str.charAt(i) < 'a' || str.charAt(i) > 'z'){
//                i++;
//                continue;
//            }
//            else if(str.charAt(j) < 'a' || str.charAt(j) > 'z'){
//                j--;
//                continue;
//            }
//
//            if(str.charAt(i) != str.charAt(j)) return false;
//            i++;
//            j--;
//        }
//        return true;
    }

}
