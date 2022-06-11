package game;

public class TicTacToe {

    public static void main(String[] args) {
        String[][] board = getEmptyBoard();

        String startMove = "X";

        startGame(board, startMove);
    }

    private static String[][] getEmptyBoard() {
        String[][] board = new String[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = "_";
            }
        }
        return board;
    }

    private static void startGame(String[][] board, String startMove) {
        System.out.println("Game has been started!");
        printBoard(board);
    }

    private static void printBoard(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }



}
