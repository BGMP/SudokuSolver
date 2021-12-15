package cl.bgmp.sudoku;

import cl.bgmp.util.ConsoleUtil;

public class Sudoku {
    private Cell[][] grid;
    private boolean solved = false;

    public Sudoku(Cell[][] grid) {
        this.grid = grid;
    }

    public boolean isSolved() {
        return solved;
    }

    public static Sudoku fromCommandLine() {
        return new Sudoku(ConsoleUtil.readSudokuGrid());
    }

    public void solve() {
        backtracking(new Cell(0, -1));
    }

    public void backtracking(Cell cell) {
        if (this.solved) {
            return;
        }

        if (reject()) {
            return;
        }

        if (accept()) {
            output();
            this.solved = true;
        }

        Cell child = first(cell);
        while (child != null) {
            Cell copy = child.copy();
            backtracking(copy);
            child = next(child);
        }
    }

    private boolean reject() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.grid[i][j].getNumber() == Cell.NOT_SET) continue;
                if (!isNumberPlacedCorrectly(this.grid[i][j])) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean accept() {
        for (int i = 8; i >= 0; i--) {
            for (int j = 8; j >= 0; j--) {
                if (this.grid[i][j].getNumber() == Cell.NOT_SET) return false;
                else if (!isNumberPlacedCorrectly(grid[i][j])) return false;
            }
        }

        return true;
    }

    private void output() {
        System.out.println(this);
    }

    private Cell first(Cell cell) {
        cell = this.getNextCell(cell);
        if (cell == null) return null;

        while (cell.getNumber() != Cell.NOT_SET) {
            cell = this.getNextCell(cell);
            if (cell == null) return null;
        }

        cell.setNumber(1);
        return cell;
    }

    private Cell next(Cell cell) {
        int number = cell.getNumber();
        if (number == 9) {
            cell.setNumber(0);
            return null;
        }

        cell.increaseNumberByOne();
        return cell;
    }

    private boolean isNumberPlacedCorrectly(Cell cell) {
        return !isNumberRepeatedInRow(cell) &&
                !isNumberRepeatedInColumn(cell) &&
                !isNumberRepeatedInBox(cell);
    }

    private boolean isNumberRepeatedInRow(Cell cell) {
        boolean foundOnce = false;
        for (int i = 0; i < 9; i++) {
            if (this.grid[cell.getRow()][i].getNumber() == cell.getNumber()) {
                if (foundOnce) {
                    return true;
                } else {
                    foundOnce = true;
                }
            }
        }

        return false;
    }

    private boolean isNumberRepeatedInColumn(Cell cell) {
        boolean foundOnce = false;
        for (int i = 0; i < 9; i++) {
            if (this.grid[i][cell.getColumn()].getNumber() == cell.getNumber()) {
                if (foundOnce) {
                    return true;
                } else {
                    foundOnce = true;
                }
            }
        }

        return false;
    }

    private boolean isNumberRepeatedInBox(Cell cell) {
        int localBoxRow = cell.getRow() - cell.getRow() % 3;
        int localBoxColumn = cell.getColumn() - cell.getColumn() % 3;

        boolean foundOnce = false;
        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
            for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
                if (this.grid[i][j].getNumber() == cell.getNumber()) {
                    if (foundOnce) {
                        return true;
                    } else {
                        foundOnce = true;
                    }
                }
            }
        }

        return false;
    }

    public Cell getNextCell(Cell current) {
        if (current.getColumn() == 8) {
            if (current.getRow() == 8) {
                return null;
            }

            return this.grid[current.getRow() + 1][0];
        }

        return grid[current.getRow()][current.getColumn() + 1];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("X-----------------------X").append("\n");
        for (int i = 0; i < 9; i++) {
            if (i != 0 && i % 3 == 0) {
                builder.append("|-----------------------|").append("\n");
                builder.append("| ");
            } else builder.append("| ");
            for (int j = 0; j < 9; j++) {
                if (j != 0 && j % 3 == 0) {
                    builder.append("| ");
                }
                builder.append(this.grid[i][j].getNumber()).append(" ");
            }
            builder.append("|");
            builder.append("\n");
        }
        builder.append("X-----------------------X");

        return builder.toString();
    }
}
