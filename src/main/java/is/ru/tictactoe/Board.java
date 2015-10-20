package is.ru.tictactoe;

public class Board {
	private final int row = 3;
	private final int col = 3;

	private Status gameStatus;
	private Cell[][] tttBoard;
	private int lastRow;
	private int lastCol;

	public Board() {
		tttBoard = new Cell[row][col];
		initializeBoard();
		gameStatus = Status.ONGOING;
	}

	private void initializeBoard() {
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				tttBoard[i][j] = new Cell(i, j, Seed.EMPTY);
			}
		}
	}

	// For debugging purposes
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
}