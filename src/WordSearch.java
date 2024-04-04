import java.util.Arrays;

public class WordSearch {
    public static void main(String[] args) {
        test(1, new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED", true);
        test(1, new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE", true);
        test(2, new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB", false);
        test(4, new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}}, "ABCESEEEFS", true);
        test(5, new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}}, "ABCEFSADEESE", true);

    }
    public static void test(int testCase, char[][] board, String word, boolean expectedOutput){
        System.out.println("Case "+testCase+": "+ (exist(board, word)==expectedOutput?"Passed":"Failed"));
    }
    public static boolean exist(char[][] board, String word){
        char character = word.charAt(0);
        boolean result = false;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if (character == board[i][j]){
                    int[] isVisited = new int[board.length*board[0].length];
                    Arrays.fill(isVisited, 0);
                    if(word.length() == 1) return true;
                    result = trace(board, word, isVisited, i, j);
                    if(result) break;
                }
            }
            if(result) break;
        }

        return result;
    }
    public static boolean trace(char[][] board, String word, int[] visited, int i, int j){

        if(word.isEmpty()) return true;
        if(i<0 || i>board.length-1 || j<0 || j>board[i].length-1 || visited[j+(i*board[i].length)]==1)
            return false;
        char character = word.charAt(0);
        if(character != board[i][j]) return false;
        int[] isVisited = Arrays.copyOf(visited ,board.length*board[0].length);
        isVisited[j+ i*board[i].length] = 1;
        word = word.substring(1);
        return trace(board, word, isVisited, i+1,j)
                ||trace(board, word, isVisited, i-1,j)
                ||trace(board, word, isVisited, i,j+1)
                ||trace(board, word, isVisited, i,j-1);
    }
}
