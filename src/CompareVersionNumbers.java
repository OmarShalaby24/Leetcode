public class CompareVersionNumbers {
    public static void main(String[] args) {
        System.out.println(compareVersion("1.01", "1.001"));
        System.out.println(compareVersion("1.0", "1.0.0"));
        System.out.println(compareVersion("0.1", "1.1"));
        System.out.println(compareVersion("1.0.1", "1"));
    }

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i=0;
        while(i<v1.length || i<v2.length){
            int x = i<v1.length ? Integer.parseInt(v1[i]) : 0;
            int y = i<v2.length ? Integer.parseInt(v2[i]) : 0;

            if(x > y) return 1;
            else if(x < y) return -1;
            i++;
        }
        return 0;
    }
}
