public class AverageWaitingTime {
    public static void main(String[] args) {
        System.out.println(averageWaitingTime(new int[][]{{1,2},{2,5},{4,3}}));
        System.out.println(averageWaitingTime(new int[][]{{5,2},{5,4},{10,3},{20,1}}));
    }
    public static double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        double timeWiating = customers[0][1];
        int finishedPrev = customers[0][0] + customers[0][1];

        for(int i=1; i<n; i++){
            int [] customer = customers[i];

            int startCooking = Math.max(customer[0], finishedPrev);
            int endCooking = startCooking + customer[1];
            finishedPrev = endCooking;
            timeWiating += endCooking - customer[0];
        }
        return timeWiating / n;
    }
}
