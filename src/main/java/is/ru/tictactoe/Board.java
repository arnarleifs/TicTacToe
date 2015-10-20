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

	public boolean isDraw() {
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(tttBoard[i][j].getMark() != Seed.EMPTY) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean hasWon(Seed candidate) {
		return ((tttBoard[lastRow][0].getMark() == candidate 
			&& tttBoard[lastRow][1].getMark() == candidate 
			&& tttBoard[lastRow][2].getMark() == candidate) 
			|| (tttBoard[0][lastCol].getMark() == candidate 
			&& tttBoard[1][lastCol].getMark() == candidate
			&& tttBoard[2][lastCol].getMark() == candidate) 
			|| (lastRow == lastCol
			&& tttBoard[0][0].getMark() == candidate
			&& tttBoard[1][1].getMark() == candidate
			&& tttBoard[2][2].getMark() == candidate)
			|| (lastRow + lastCol == 2
			&& tttBoard[0][2].getMark() == candidate
			&& tttBoard[1][1].getMark() == candidate
			&& tttBoard[2][0].getMark() == candidate));
	}

	// Mainly for testing hasWon()
	public void setNewCell(int row, int col, Seed newMark) {
		tttBoard[row][col].setMark(newMark);
		lastRow = row;
		lastCol = col;
	}
}