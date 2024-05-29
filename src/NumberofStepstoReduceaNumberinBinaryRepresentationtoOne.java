public class NumberofStepstoReduceaNumberinBinaryRepresentationtoOne {
    public static void main(String[] args) {
//        String s = "1111011110000011100000110001011011110010111001010111110001";
        String s = "1101";
        System.out.println(numSteps_2(s));
    }

    public static int numSteps(String s) {
        int count = 0;
        while (s.length() > 1) {
            int itr = s.length() - 1;
            if (s.charAt(itr) == '0') {
                s = s.substring(0, s.length() - 1);
            } else {
                int i = s.length() - 1;
                while (s.charAt(i) == '1') {
                    s = s.substring(0, i) + '0' + s.substring(i + 1);
                    i--;
                    if (i == -1) {
                        s = "1" + s;
                        i = 0;
                        break;
                    }
                }
                s = s.substring(0, i) + '1' + s.substring(i + 1);
            }
            count++;
        }
        return count;
    }

    public static int numSteps_2(String s) {
        int count = 0;
        int carry = 0;

        for (int i = s.length() - 1; i > 0; i--) {
            count++;
            if (s.charAt(i) - '0' + carry == 1) {
                carry = 1;
                count++;
            }
        }
        return count + carry;
    }
}
