public class ValidSudoku {
    public static void main(String[] args) {
        Board board = new Board(new char[][]{{'9','3','.','.','7','.','.','.','.'}, {'6','.','.','1','9','5','.','.','.'}, {'.','9','8','.','.','.','.','6','.'}, {'8','.','.','.','6','.','.','.','3'}, {'4','.','.','8','.','3','.','.','1'}, {'7','.','.','.','2','.','.','.','6'}, {'.','6','.','.','.','.','2','8','.'}, {'.','.','.','4','1','9','.','.','5'}, {'.','.','.','.','8','.','.','7','9'}});
        System.out.println(board.checkValid());

    }
}

class Board{
    private char[][] state;
    Board(char[][] values){
        this.state = values;
    }

    public boolean checkForCell(int x, int y){
        char cell = this.state[x][y];
//        if(cell == '.') return false;
        //determine which subSquare
        int[] dim = {(x/3)*3, (y/3)*3};
//        System.out.println(dim[0] + " " + dim[1]);

        for(int i = dim[0]; i<3+dim[0]; i++){
            for(int j=dim[1]; j<3+dim[1]; j++){
                if((i == x && j ==y) || (this.state[i][j] == '.')) continue;
//                System.out.println("[ "+i+" , "+j+" ]");
                if(this.state[i][j] == cell) return false;
            }
        }
        return true;
    }

    public boolean checkValid(){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                char cell = this.state[i][j];
                //check for row
                if(cell == '.') continue;
                for(int k=0; k<9; k++) {
                    if (k == j) continue;
                    if (cell == this.state[i][k]) return false;
                }
                //check for column
                for(int k=0; k<9; k++){
                    if(k == i) continue;
                    if (cell == this.state[k][j]) return false;
                }
                //check for square
                if(!checkForCell(i,j)) return false;
            }
        }
        return true;
    }

    public void print(){
        for(int i=0; i<9; i++){
            System.out.print("[");
            for(int j=0; j<9; j++){
                System.out.print((this.state[i][j] == '.'? " ":this.state[i][j]));
                if(j == 8) System.out.println("]");
                else System.out.print(", ");
            }
        }
    }

}


//for(int i=0; i<9; i++){
//        System.out.print("[");
//            for(int j=0; j<9; j++){
//        System.out.print((this.state[i][j] == '.'? " ":this.state[i][j]));
//        if(j == 8) System.out.println("]");
//                else System.out.print(", ");
//            }
////            if(i%3==2) System.out.println("_______________________");
//                    }