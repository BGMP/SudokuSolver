package cl.bgmp.sudoku;

public class Cell {
    public static final int NOT_SET = 0;

    private int row;
    private int column;
    private int number = NOT_SET;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Cell(int row, int column, int number) {
        this.row = row;
        this.column = column;
        this.number = number;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void increaseNumberByOne() {
        this.number++;
    }

    public Cell copy() {
        return new Cell(this.row, this.column, this.number);
    }

    @Override
    public String toString() {
        return "Cell@[" + this.row + "][" + this.column + "]";
    }
}
