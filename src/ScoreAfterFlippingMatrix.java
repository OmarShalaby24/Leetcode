import java.util.Arrays;

public class ScoreAfterFlippingMatrix {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        int score = matrixScore(grid);
        System.out.println(score);

    }

    public static int matrixScore(int[][] grid) {
        for(int r=0; r<grid.length; r++){
            if(grid[r][0] == 0) toggleRow(grid, r);
        }
        int flag1 = 0;
        for(int c=1; c<grid[0].length; c++){
            int flag2 = 0;
            for(int r=0; r<grid.length; r++){
                if(grid[r][c] == 0) flag2++;
            }
            if((float)flag2 > (float) grid.length/2) toggleColumn(grid, c);
        }
        int sum = 0;
        for(int[] row : grid){
            sum += checkRow(row);
        }
        return sum;
    }

    private static int checkRow(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result * 2 + num;
        }
        return result;
    }

    public static void toggleColumn(int[][] grid, int col){
        for(int i=0; i<grid.length; i++){
            grid[i][col] = 1 - grid[i][col];
        }
    }
    public static void toggleRow(int[][] grid, int row){
        for(int i=0; i<grid[row].length; i++){
            grid[row][i] = 1 - grid[row][i];
        }
    }
}
