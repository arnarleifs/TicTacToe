package is.ru.tictactoe;

public class Cell {
    private int row;
    private int col;
    private Seed mark;

    public Cell(int row, int col, Seed mark) {
        this.row = row;
        this.col = col;
        this.mark = mark;
    }

    public void empty() {
        this.mark = Seed.EMPTY;
    }

    public boolean isEmpty() {
        return this.mark == Seed.EMPTY;
    }

    public void setMark(Seed newMark) {
        this.mark = newMark;
    }

    public boolean checkMark(Seed mark) {
        return this.mark == mark;
    }

    public Seed getMark() {
        return this.mark;
    }
}
