import java.lang.*;

public class longestPalindrome {
    public static void main(String[] args) {
//        System.out.println(longestPalindrome("ccc"));
        System.out.println(longestPalindrome("cbbd"));
//        System.out.println(longestPalindrome("abcddcba"));
//        System.out.println(longestPalindrome("uethoohbookkoob"));
//        System.out.println(longestPalindrome("magnificentcatstacaretheremanymoreplacesthatemphasizetheabilityabbazezalphaduethoohbookkoobtogetoutthereandwin"));
//        System.out.println(longestPalindrome("sayitaintsoiwillnotgoturnthelightsoffcarrymehomenanananananananananananananananananananananananananananananananananananananananaverse2tomdelongelatenightcomehomeworksucksiknowsheleftmerosesbythestairssurprisesletmeknowshecareschorustomdelongesayitaintsoiwillnotgoturnthelightsoffcarrymehome"));
    }

    public static String longestPalindrome(String s){
        if(s.length() <= 1) return s;
        java.lang.String longestPalindromeString = "";
        int start=0, end=0;
        for(int i=0; i<s.length(); i++){
            String str="";
            String str2="";
            while((isPalindrome(str) || isPalindrome(str2)) && (i+start>=0)){
                str = s.substring(i+start, i+end+1);
                if((i+end+1<s.length())) str2 = s.substring(i+start, i+end+2);
                boolean flag = false;
                if(isPalindrome(str) && longestPalindromeString.length() < str.length()){
                    longestPalindromeString = str;
                    flag = true;
                }
                if(isPalindrome(str2) && longestPalindromeString.length() < str2.length()){
                    longestPalindromeString = str2;
                    flag = true;
                }
                if(!flag) break;
                start--;
                end++;
            }
        }
        return longestPalindromeString;
    }
    public static boolean isPalindrome(String s){
        for(int i=0, j=s.length()-1; i<=s.length()/2 && j>=s.length()/2; i++, j--){
//            System.out.println(s.charAt(i)+"  "+ s.charAt(j));
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}
//function longestPalindrome(s: string): string {
//    if(s.length <= 1) return s;
//    var longestPalindrome: string = "";
//    var start:number = 0;
//    var end: number = 0;
//    for(var i=0; i<s.length; i++){
//        // if(i-start < 0 || i+end > s.length-1) continue;
//        var str = s.slice(start, end+1);
//        while(isPalindrome(str) && i-start>=0 && i+end<s.length){
//            start--;
//            end++;
//            str = str.slice(start, end+1);
//            if(longestPalindrome.length < str.length){
//                longestPalindrome = str;
//            }
//        }
//
//
//    }
//    return longestPalindrome;
//};