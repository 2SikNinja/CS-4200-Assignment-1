public class EightQueens {
     public static void main(String[] args) {
         int[][] board = new int[8][8];
         if (placeQueens(board, 0)) {
             printBoard(board);
         } else {
             System.out.println("No solution exists.");
         }
     }
 
     public static boolean placeQueens(int[][] board, int col) {
         if (col == 8) {
             return true; // all queens have been placed
         }
         for (int row = 0; row < 8; row++) {
             if (isSafe(board, row, col)) {
                 board[row][col] = 1; // place the queen
                 if (placeQueens(board, col + 1)) {
                     return true; // found a solution
                 }
                 board[row][col] = 0; // backtrack and try the next row
             }
         }
         return false; // no solution found in this column
     }
 
     public static boolean isSafe(int[][] board, int row, int col) {
         for (int i = 0; i < col; i++) {
             if (board[row][i] == 1) {
                 return false; // there is a queen in the same row
             }
             if (row - (col - i) >= 0 && board[row - (col - i)][i] == 1) {
                 return false; // there is a queen in the same diagonal
             }
             if (row + (col - i) < 8 && board[row + (col - i)][i] == 1) {
                 return false; // there is a queen in the same diagonal
             }
         }
         return true; // the position is safe
     }
 
     public static void printBoard(int[][] board) {
         for (int i = 0; i < 8; i++) {
             for (int j = 0; j < 8; j++) {
                 System.out.print(board[i][j] + " ");
             }
             System.out.println();
         }
     }
 }
 