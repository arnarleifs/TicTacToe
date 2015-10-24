package is.ru.tictactoe;

public class Board {
	private final int row = 3;
	private final int col = 3;

	private Status gameStatus;
	private Cell[][] tttBoard;
	private int lastModifiedRow;
	private int lastModifiedCol;

	public Board() {
		tttBoard = new Cell[row][col];
		initializeBoard();
		gameStatus = Status.ONGOING;
	}

	public boolean isDraw() {
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(tttBoard[i][j].getMark() == Seed.EMPTY) {
					return false;
				}
			}
		}
		return true;
	}

	private void initializeBoard() {
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				tttBoard[i][j] = new Cell(i, j, Seed.EMPTY);
			}
		}
	}

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

	public boolean hasWon(Seed candidate) {
		return hasWonOnRowLevel(candidate) || hasWonOnColumnLevel(candidate) || hasWonOnDiagonal(candidate)
			   || hasWonOnOppositeDiagonal(candidate);
	}

	private boolean hasWonOnRowLevel(Seed candidate) {
		return (tttBoard[lastModifiedRow][0].getMark() == candidate 
			&& tttBoard[lastModifiedRow][1].getMark() == candidate 
			&& tttBoard[lastModifiedRow][2].getMark() == candidate);
	}

	private boolean hasWonOnColumnLevel(Seed candidate) {
		return (tttBoard[0][lastModifiedCol].getMark() == candidate 
			&& tttBoard[1][lastModifiedCol].getMark() == candidate
			&& tttBoard[2][lastModifiedCol].getMark() == candidate);
	}

	private boolean hasWonOnDiagonal(Seed candidate) {
		return (tttBoard[0][0].getMark() == candidate
			&& tttBoard[1][1].getMark() == candidate
			&& tttBoard[2][2].getMark() == candidate);
	}

	private boolean hasWonOnOppositeDiagonal(Seed candidate) {
		return (tttBoard[0][2].getMark() == candidate
			&& tttBoard[1][1].getMark() == candidate
			&& tttBoard[2][0].getMark() == candidate);
	}

	public void setNewCell(int row, int col, Seed newMark) {
		tttBoard[row][col].setMark(newMark);
		lastModifiedRow = row;
		lastModifiedCol = col;
	}
}