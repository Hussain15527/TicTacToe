import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static final Scanner cin = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        int rowSize = board.length;
        int colSize = board[0].length;
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                board[row][col] = ' ';
            }
        }
        char player = 'X';
        boolean gameOver = false;
        while (!gameOver) {
            printBoard(board);
            System.out.println("Player " + player + " enter");
            int row = cin.nextInt();
            int col = cin.nextInt();
            if (board[row][col] == ' ') {
                board[row][col] = player;
                // check if game is over
                gameOver = haveWon(board, player);
                // if it is over than print the player symbol.
                if (gameOver) {
                    printBoard(board);
                    System.out.println("Payer " + player + " has won");
                    break;
                }
                // if the game is not over, change the player.
                else {
                    if (player == 'X') {
                        player = 'O';
                    } else {
                        player = 'X';
                    }
                }
            }
            // in case the player uses the already used tile
            else {
                System.out.println("Invalid move, play again");
            }
        }
        // printBoard(board);
    }

    // checks if the player has won or not
    private static boolean haveWon(char[][] board, char player) {
        // checking if the player has three col equal.
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0] == player) {
                return true;
            }
        }
        // if three row are equal
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == board[1][col] && board[1][col] == board[2][col] && board[0][col] == player) {
                return true;
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] == player)
            return true;
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] == player)
            return true;
        return false;
    }

    // prints the board
    public static void printBoard(char[][] board) {
        int rowSize = board.length;
        int colSize = board[0].length;
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}
