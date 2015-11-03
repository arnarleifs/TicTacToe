package is.ru.tictactoe;

/**
  * Class Boardindex is used to calculate the Tic Tac Toe
  * board indexes.
  */
public class BoardIndex {
    private double x;
    private double y;
    private int rowIndex;
    private int colIndex;

    /**
      * Creates a new boardindex from a given x and y coordinate.
      * 
      * @param x The x value passed to boardindex
      * @param y The y value passed to boardindex
      */
    public BoardIndex(double x, double y) {
        this.x = x;
        this.y = y;
        calculateIndex();
    }
    
    /**
      * Calculates a Tic Tac Toe boards index from the classes
      * x and y parameters. Sets the class parameters rowIndex
      * and colIndex from x and y position
      */
    private void calculateIndex() {
        if(this.x > 0 && this.x < 100) {
            this.colIndex = 0;
            this.rowIndex = calculateRowIndex();
        } else if(this.x > 100 && this.x < 200) {
            this.colIndex = 1;
            this.rowIndex = calculateRowIndex();
        } else if(this.x > 200 && this.x < 300) {
            this.colIndex = 2;
            this.rowIndex = calculateRowIndex();
        }
    }
    
     
     /**
      * Specifically calculates the row index
      *
      * @return The Tic Tac Toe row index. -1 if y value is invalid
      */
    private int calculateRowIndex() {
        if(this.y > 0 && this.y < 100) {
            return 0;
        } else if (this.y > 100 && this.y < 200) {
            return 1;
        } else if (this.y > 200 && this.y < 300) {
            return 2;
        }
        return -1;
    }

    /**
      * Checks if the x and y value are valid
      *
      * @param x The x value to be calculated
      * @param y The y value to be calculated
      * @return Boolean true if x and y are legal values, false else
      */
    public static boolean checkIndex(double x, double y) {
        if(x % 100 == 0 || y % 100 == 0) {
            return false;
        }
        return true;
    }
    
    /**
      * Getter for the variable rowIndex
      *
      * @return Variable rowIndex
      */
    public int getRowIndex() {
        return rowIndex;
    }

    /**
      * Getter for the variable colIndex
      *
      * @return Variable colIndex
      */
    public int getColIndex() {
        return colIndex;
    }
}
