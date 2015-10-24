package is.ru.tictactoe;

public class BoardIndex {
	private double x;
	private double y;
	private int rowIndex;
	private int colIndex;

	public BoardIndex(double x, double y) {
		this.x = x;
		this.y = y;
		calculateIndex();
	}

	private void calculateIndex() {
		if(this.x > 0 && this.x < 100) {
			this.x = 0;
			this.y = calculateRowIndex();
		} else if(this.x > 100 && this.x < 200) {
			this.x = 1;
			this.y = calculateRowIndex();
		} else if(this.x > 200 && this.x < 300) {
			this.x = 2;
			this.y = calculateRowIndex();
		}
	}

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

	public static boolean checkIndex(double x, double y) {
		if(x % 100 == 0 || y % 100 == 0) {
			return false;
		}
		return true;
	}

	public int getRowIndex() {
		return rowIndex;
	}

	public int getColIndex() {
		return colIndex;
	}
}