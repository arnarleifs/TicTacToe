package is.ru.tictactoe;

/**
 * Board class contains a whole playing board for the
 * game Tic Tac Toe.
 */
public class Board {
    private final int row = 3;
    private final int col = 3;

    private Status gameStatus;
    private Cell[][] tttBoard;
    private int lastModifiedRow;
    private int lastModifiedCol;
    private Seed turn;

    /**
     * Builds a new game board for a game of Tic Tac Toe
     */
    public Board() {
        tttBoard = new Cell[row][col];
        initializeBoard();
        gameStatus = Status.ONGOING;
        turn = Seed.CROSS;
    }

    /**
     * Scans the board to see if all cells have been filled thus
     * resulting in a draw.
     *
     * @return True no empty cells remain, false otherwise
     */
    public boolean isDraw() {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(tttBoard[i][j].getMark() == Seed.EMPTY) {
                    return false;
                }
            }
        }
        gameStatus = Status.DRAW;
        return true;
    }

    /**
     * Initializes a game board by creating new cells and 
     * setting them as empty.
     */
    private void initializeBoard() {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                tttBoard[i][j] = new Cell(i, j, Seed.EMPTY);
            }
        }
    }

    /**
     * Verifies that a board is fully initialised by visiting
     * each cell and confirming it as empty
     *
     *@return True if each cell is empty, false otherwise
     */
    public boolean isInitialized() {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(tttBoard[i][j].getMark() != Seed.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks the board to see if a player has won in any direction
     *
     * @param candidate The candidate is either 'X' or 'O' 
     * @return won boolean representing true if candidate has won and false otherwise
     */
    public boolean hasWon(Seed candidate) {
        boolean won = hasWonOnRowLevel(candidate) || hasWonOnColumnLevel(candidate)
                      || hasWonOnDiagonal(candidate) || hasWonOnOppositeDiagonal(candidate);
        if(won) {
            if (candidate == Seed.CROSS) {
                gameStatus = Status.CROSS_WON;
            } else {
                gameStatus = Status.CIRCLE_WON;
            } 
        }
        return won;
    }

    /**
     * Returns the status of the current game being played
     *
     * @return gameStatus represents the status of the current game
     */
    public Status getGameStatus() {
        return gameStatus;
    }

    /**
     * Checks if candidate has won on the last row that was modified
     *
     * @param candidate Represents the player 'X' or 'O'
     * @return True if the player has won on the last modified row, false otherwise
     */
    private boolean hasWonOnRowLevel(Seed candidate) {
        return (tttBoard[lastModifiedRow][0].getMark() == candidate 
            && tttBoard[lastModifiedRow][1].getMark() == candidate 
            && tttBoard[lastModifiedRow][2].getMark() == candidate);
    }

    /**
     * Checks if candidate has won on the last column that was modified
     *
     * @param candidate Represents the player 'X' or 'O'
     * @return True if the player has won on the last modified column, false otherwise
     */
    private boolean hasWonOnColumnLevel(Seed candidate) {
        return (tttBoard[0][lastModifiedCol].getMark() == candidate 
            && tttBoard[1][lastModifiedCol].getMark() == candidate
            && tttBoard[2][lastModifiedCol].getMark() == candidate);
    }

    /**
     * Checks if candidate has won diagonal on the board
     *
     * @param candidate Represents the player 'X' or 'O'
     * @return True if the player has won diagonal on the board, false otherwise
     */
    private boolean hasWonOnDiagonal(Seed candidate) {
        return (tttBoard[0][0].getMark() == candidate
            && tttBoard[1][1].getMark() == candidate
            && tttBoard[2][2].getMark() == candidate);
    }

    /**
     * Checks if candidate has won opposite diagonal on the board
     *
     * @param candidate Represents the player 'X' or 'O'
     * @return True if the player has won opposite diagonal on the board, false otherwise
     */
    private boolean hasWonOnOppositeDiagonal(Seed candidate) {
        return (tttBoard[0][2].getMark() == candidate
            && tttBoard[1][1].getMark() == candidate
            && tttBoard[2][0].getMark() == candidate);
    }

    /**
     * Updates the mark of a given cell as well as the last modified
     * row and the last modified column
     *
     * @param r The row to be modified
     * @param c The column to be modified
     * @param newMark The mark which the cell should be updated with
     */
    public void setNewCell(int r, int c, Seed newMark) {
        tttBoard[r][c].setMark(newMark);
        lastModifiedRow = r;
        lastModifiedCol = c;
        if(turn == Seed.CROSS) {
            turn = Seed.CIRCLE;
        } else {
            turn = Seed.CROSS;
        }
    }

    /**
     * Returns whose turn it is to play
     *
     * @return The Seed of the player whose turn it is
     */
    public Seed whichTurn() {
        return this.turn;
    }

    /**
     * Asks if a particular cell is empty or not
     *
     * @param r The row to be inspected
     * @param c The column to be inspected
     * @return True if the cell at row r and column c is empty, false otherwise
     */
    public boolean isEmpty(int r, int c) {
        return tttBoard[r][c].getMark() == Seed.EMPTY;
    }

    /**
     * Gets the seed from a chosen cell
     *
     * @param r The row to be inspected
     * @param c The column to be inspected
     * @return The mark residing at the chosen cell
     */
    public Seed getSeedFromPosition(int r, int c) {
        return tttBoard[r][c].getMark();
    }
}

