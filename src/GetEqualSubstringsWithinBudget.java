public class GetEqualSubstringsWithinBudget {
    public static void main(String[] args) {
        System.out.println(equalSubstring("abcd", "bcdf", 3) + " Expected: 3");
        System.out.println(equalSubstring("abcd", "cdef", 3) + " Expected: 1");
        System.out.println(equalSubstring("abcd", "acde", 0) + " Expected: 1");
        System.out.println(equalSubstring("krrgw", "zjxss", 19) + " Expected: 2");
        System.out.println(equalSubstring("pxezla", "loewbi", 25) + " Expected: 4");
    }

    public static int equalSubstring(String s, String t, int maxCost){
        int[] diffs = new int[s.length()];

        for(int i=0; i<s.length(); i++)
            diffs[i] = Math.abs(s.charAt(i) - t.charAt(i));

        int end =  0;
        int sum = 0, maxLength=0;
        for(int start=0; start<s.length(); start++){
            sum+= diffs[start];
            while (sum > maxCost){
                sum -= diffs[end];
                end++;
            }
            maxLength = Math.max(maxLength, start - end +1);
        }
        return maxLength;
    }
}
