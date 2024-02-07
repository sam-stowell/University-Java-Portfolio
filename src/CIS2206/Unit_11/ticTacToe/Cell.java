package CIS2206.Unit_11.ticTacToe;

/**
 * Implements a Cell of a Tic Tac Toe 2D array
 *
 * @author Ilias Tachmazidis
 * @version September 2023
 */
public class Cell {

    private int value;

    public Cell(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
