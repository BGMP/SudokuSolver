package cl.bgmp;

import cl.bgmp.sudoku.Sudoku;

public class SudokuSolver {

    public static void main(String[] args) {
        // Sudoku sudoku = Sudoku.fromCommandLine();
        Sudoku sudoku = Sudoku.fromArray(Boards.SAMPLE_1);

        System.out.println();
        System.out.println("Sudoku:");
        System.out.println(sudoku);
        System.out.println();

        System.out.println("Solution:");
        sudoku.solve();
        if (!sudoku.isSolved()) {
            System.out.println("This Sudoku does not have a solution.");
        }
    }
}
