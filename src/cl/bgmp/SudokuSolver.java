package cl.bgmp;

import cl.bgmp.sudoku.Sudoku;

public class SudokuSolver {

    public static void main(String[] args) {
        Sudoku sudoku = Sudoku.fromCommandLine();

        System.out.println();
        System.out.println("Sudoku ingresado:");
        System.out.println(sudoku);
        System.out.println();

        System.out.println("Solución:");
        sudoku.solve();
        if (!sudoku.isSolved()) {
            System.out.println("- El Sudoku no tiene solución.");
        }
    }
}
