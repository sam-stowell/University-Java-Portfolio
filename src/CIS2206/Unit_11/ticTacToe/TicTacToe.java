package CIS2206.Unit_11.ticTacToe;

import java.util.Random;

/**
 * This class implements a game of Tic-Tac-Toe.
 *
 * @author Ilias Tachmazidis
 * @version September 2023
 */
public class TicTacToe {
    Cell[][] board;
    final int X = 1, O = -1, EMPTY = 0, rows = 3, columns = 3;
    private int player;

    /**
     * Constructor used in order to intialise a game
     */
    public TicTacToe() {
        // Create array of cells
        board = new Cell[rows][columns];

        // Initialize array of cells
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Cell(EMPTY);
            }
        }

        // Start game with player X
        player = X;
    }

    /**
     * Updates the board by adding player's mark and subsequently
     * switching players.
     *
     * @param i Row to be updated
     * @param j Column to be updated
     * @return Return a boolean value indicating whether the board was updated
     */
    public boolean putMark(int i, int j) {
        // Check index range and cell contents
        if ((i < 0) || (i > 2) ||
                (j < 0) || (j > 2) ||
                (board[i][j].getValue() != EMPTY)) {
            return false;
        } else {
            board[i][j].setValue(player); // place the mark for the current player
            player = -player; // switch players (uses fact that O = - X)
            return true;
        }
    }

    /**
     * Checks the board for a potential win (a player's mark appearing
     * in any row, column or diagonal).
     *
     * @param mark Player's mark to check for a win
     * @return Returns a boolean value indicating whether the player has won the game
     */
    public boolean isWin(int mark) {
        return ((board[0][0].getValue() + board[0][1].getValue() + board[0][2].getValue() == mark * 3) // row 0
                || (board[1][0].getValue() + board[1][1].getValue() + board[1][2].getValue() == mark * 3) // row 1
                || (board[2][0].getValue() + board[2][1].getValue() + board[2][2].getValue() == mark * 3) // row 2
                || (board[0][0].getValue() + board[1][0].getValue() + board[2][0].getValue() == mark * 3) // column 0
                || (board[0][1].getValue() + board[1][1].getValue() + board[2][1].getValue() == mark * 3) // column 1
                || (board[0][2].getValue() + board[1][2].getValue() + board[2][2].getValue() == mark * 3) // column 2
                // diagonal: top-left to bottom-right
                || (board[0][0].getValue() + board[1][1].getValue() + board[2][2].getValue() == mark * 3)
                // diagonal: top-right to bottom-left
                || (board[2][0].getValue() + board[1][1].getValue() + board[0][2].getValue() == mark * 3));
    }

    /**
     * Returns the winner of the game.
     *
     * @return Returns a value indicating the winner of the game
     */
    public int winner() {
        return isWin(X) ? X : (isWin(O) ? O : EMPTY);
    }

    /**
     * Create a String representation of the game
     *
     * @return Returns a String representation of the game
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getValue() == X) {
                    sb.append("X");
                } else if (board[i][j].getValue() == O) {
                    sb.append("O");
                } else {
                    sb.append(" ");
                }
                if (j < board[i].length - 1) {
                    sb.append("|");
                } // columns
            }
            if (i < board[i].length - 1) {
                sb.append("\n");
            } // rows
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Instantiate a game
        TicTacToe game = new TicTacToe();

        // Automatically play a full game by assigning marks at
        // random places on the board
        Random rand = new Random();
        for (int i = 0; i < 9; i++) {

            // Keep guessing until a valid step is made
            while (!game.putMark(rand.nextInt(game.rows), rand.nextInt(game.columns))) ;

            // Print progress
            System.out.println(game);
            System.out.println("-----");

            // Stop game is winner occurs before all cells are filled
            if (game.winner() != game.EMPTY) {
                break;
            }
        }

        // Indicate winner (if any)
        int winningPlayer = game.winner();
        String[] outcome = {"O wins", "Tie", "X wins"}; // rely on ordering
        System.out.println("Outcome: " + outcome[1 + winningPlayer]);
    }
}
