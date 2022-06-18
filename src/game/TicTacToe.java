package game;

import java.util.Scanner;

public class TicTacToe {


    private static String turn = "X";
    private static Scanner scan = new Scanner(System.in);

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
        System.out.println(startMove + "'s turn");
        play(board);

    }

    private static void printBoard(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }




    private static boolean boardIsFull(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals("_")) {
                    return false;
                }
            }
        }
        return true;
    }


    private static String isWinner(String[][] board) {

        String start = turn.equals("X") ? "O" : "X";
        for (int i = 0; i < board.length; i++) {
            boolean result = true;
            for (int j = 0; j < board.length; j++) {
                result = result && start.equals(board[i][j]);
            }
            if (result) {
                return start;
            }
        }
        for (int j = 0; j < board.length; j++) {
            boolean result = true;
            for (int i = 0; i < board.length; i++) {
                result = result && start.equals(board[i][j]);
            }
            if (result) {
                return start;
            }
        }
        boolean result = true;
        for (int i = 0; i < board.length; i++) {
            result = result && start.equals(board[i][i]);
            }
        if (result) {
            return start;
        }
        boolean reversedResult = true;
        int alt = board.length - 1;
        for (int i = 0; i < board.length; i++) {
            reversedResult = reversedResult && start.equals(board[i][alt]);
            alt--;
        }
        if (reversedResult) {
            return start;
        }

        return null;
    }



    private static void changePlayer() {
        if (turn.equals("X")) {
            turn = "O";
        } else {
            turn = "X";
        }
    }



    public static void play(String[][] board) {
        while (!boardIsFull(board) && isWinner(board) == null) {
            int x = scan.nextInt() - 1;
            int y = scan.nextInt() - 1;
            while (x > 3 || y > 3 || board[x][y].equals("X") || board[x][y].equals("O")) {
                System.out.println("You can not put a mark here, try again");
                printBoard(board);
                x = scan.nextInt() - 1;
                y = scan.nextInt() - 1;
            }
            board[x][y] = turn;

            changePlayer();
            printBoard(board);
            if (!boardIsFull(board) && isWinner(board) == null) {
                System.out.println(turn + "'s turn");
            } else if (isWinner(board) != null) {
                System.out.println((turn.equals("X") ? "O" : "X") + " " +"has won");
            } else {
                System.out.println("Draw");
            }

        }

    }
}