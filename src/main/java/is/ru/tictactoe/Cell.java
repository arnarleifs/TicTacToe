package is.ru.tictactoe;

/**
 * The cell class represents a single cell on a Tic Tac Toe
 * board. 
 */
public class Cell {
    private int row;
    private int col;
    private Seed mark;

    /**
     * Initializes a single cell with a specific place
     * on a board and a mark representing its state.
     *
     * @param row The row containing this cell
     * @param col The column containig this cell
     * @param mark The current status of this cell
     */
    public Cell(int row, int col, Seed mark) {
        this.row = row;
        this.col = col;
        this.mark = mark;
    }

    /**
     * Sets current cells status to EMPTY
     */
    public void empty() {
        this.mark = Seed.EMPTY;
    }

    /**
     * Returns true if the current cell is EMPTY and false otherwise
     * 
     * @return True if cell is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.mark == Seed.EMPTY;
    }

    /**
     * Sets current cell Seed to newMark
     *
     * @param newMark The new Seed to mark the cell with 
     */
    public void setMark(Seed newMark) {
        this.mark = newMark;
    }

    /**
     * Returns true if the current cell Seed is the same as mark
     * and false otherwise
     *
     * @param mark The mark to compare to the cell's Seed
     * @return True if this.mark equals mark, false otherwise
     */ 
    public boolean checkMark(Seed mark) {
        return this.mark == mark;
    }

    /**
     * Returns the current cell's Seed
     *
     * @return The current cell's Seed
     */
    public Seed getMark() {
        return this.mark;
    }
}
