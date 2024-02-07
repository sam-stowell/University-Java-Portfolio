package CIS2206.Unit_20;

/**
 * Prints recursively a triangle
 *
 * @author Ilias Tachmazidis
 * @version September 2023
 */
public class Triangle {

    static int size = 5;
    static char[][] board = new char[size][size];

    /**
     * A recursive function that prints a single row
     * of a triangle on a (n x n) board
     *
     * @param row    the row to be updated
     * @param column the column to be updated
     */
    public static void triangleUpdateRow(int row, int column) {
        if (column < 0) { // base case
            return;
        }

        // Bottom left triangle
        int i = row, j = column;
        // Bottom right triangle
//        int i = row, j = size - 1 - column;
        // Top left triangle
//        int i = size - 1 - row, j = column;
        // Top right triangle
//        int i = size - 1 - row, j = size - 1 - column;

        board[i][j] = '*';

        // recursive case, progress (through columns)
        triangleUpdateRow(row, column - 1);
    }

    /**
     * A recursive function that prints a triangle
     * on a (n x n) board
     *
     * @param n the dimension size of the array
     */
    public static void triangle(int n) {
        if (n < 0) { // base case
            return;
        }

        triangleUpdateRow(n, n);

        triangle(n - 1); // recursive case, progress (through rows)
    }

    public static void main(String[] args) {
        // Initialize the board with character ' '
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' ';
            }
        }

        triangle(size - 1);

        // Print final board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}