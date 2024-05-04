import java.util.Arrays;

public class BoatsToSavePeople {
    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{1,2}, 3));
        System.out.println(numRescueBoats(new int[]{3,2,2,1}, 3));
        System.out.println(numRescueBoats(new int[]{3,5,3,4}, 5));
    }

    public static int numRescueBoats(int[] people, int limit) {
        people = Arrays.stream(people).sorted().toArray();
        int[] visited = new int[people.length];
        int counter = 0;
        for(int i=people.length-1; i>-1; i--){
            if(visited[i] == 1) continue;
            if(people[i] == limit){
                counter++;
                continue;
            }
            boolean coupleFound = false;
            for(int j=i-1; j>-1; j--){
                if(visited[j] ==0 && people[i] + people[j] <= limit){
                    counter++;
                    visited[i] = 1;
                    visited[j] = 1;
                    coupleFound = true;
                    break;
                }
            }
            if(!coupleFound){
                visited[i] = 1;
                counter++;
            }
        }
        return counter;
    }
}
