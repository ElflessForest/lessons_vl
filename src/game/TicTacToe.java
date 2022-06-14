package game;

import java.util.Scanner;

public class TicTacToe {


    private static String turn;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
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

    private static void changePlayer() {
        if (turn.equals("X")) {
            turn = "O";
        } else {
            turn = "X";
        }
    }
    public static void gameplay(String[][] board, Scanner scan) {
        int x = scan.nextInt();
        int y = scan.nextInt();
        if (x > 3 || y > 3 || board[x][y].equals("X") || board[x][y].equals("O")) {
            System.out.println("You can not put a mark here, try again");
            x = scan.nextInt();
            y = scan.nextInt();
        } else {
            board[x][y] = turn;
        }

        changePlayer();
        printBoard(board);
    }
}
