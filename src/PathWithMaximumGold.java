
public class PathWithMaximumGold {
    public static void main(String[] args) {
        System.out.println(getMaximumGold(new int[][]{{0,6,0},{5,8,7},{0,9,0}}));
        System.out.println(getMaximumGold(new int[][]{{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}}));
        System.out.println(getMaximumGold(new int[][]{{1,0,7,0,0,0},
                                                      {2,0,6,0,1,0},
                                                      {3,5,6,7,4,2},
                                                      {4,3,1,0,2,0},
                                                      {3,0,5,0,20,0}}));
    }

    public static int getMaximumGold(int[][] grid) {

        int result = 0;
        int[][] g ;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                g = copy2DArray(grid);
                result = Math.max(explore(g, i, j), result);
            }
        }
        return result;
    }

    public static int[][] copy2DArray(int[][] original) {
        int rows = original.length;
        int cols = original[0].length;
        int[][] copy = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, cols);
        }
        return copy;
    }
    public static int explore(int[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>= grid[i].length || grid[i][j] == 0) return 0;
        int gold = grid[i][j];
        grid[i][j] = 0;
        int nextRes = 0;
        nextRes = Math.max(explore(grid, i+1, j), nextRes);
        nextRes = Math.max(explore(grid, i-1, j), nextRes);
        nextRes = Math.max(explore(grid, i, j+1), nextRes);
        nextRes = Math.max(explore(grid, i, j-1), nextRes);
        grid[i][j] = gold;
        return gold + nextRes;
    }
}
