package cl.bgmp.util;

import cl.bgmp.sudoku.Cell;

import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class ConsoleUtil {

    public static void printSudokuInputInstructions() {
        System.out.println("Input the empty cells/numbers of your 9x9 Sudoku:");
        System.out.println("- To represent an empty cell use a 0.");
        System.out.println("- For separating cells use a space.");
        System.out.println("- You must provide 9 numbers for each row.");
        System.out.println("- To input each row and go to the next simply press Enter.");
        System.out.println();
    }

    public static Cell[][] readSudokuGrid() {
        ConsoleUtil.printSudokuInputInstructions();

        Cell[][] grid = new Cell[9][9];
        for (int i = 0; i < grid.length; i++) {
            grid[i] = readSudokuRow(i);
        }

        return grid;
    }

    private static Cell[] readSudokuRow(int rowNumber) {
        Scanner scanner = new Scanner(System.in);
        String row = scanner.nextLine();

        String[] numberStrings = new String[0];
        try {
            numberStrings = row.split(" ");
        } catch (PatternSyntaxException e) {
            System.out.println("The entered row is invalid! Follow the instructions.");
            readSudokuRow(rowNumber);
        }

        if (numberStrings.length != 9) {
            System.out.println("The entered row contains an invalid amount of numbers. It must have 9.");
            readSudokuRow(rowNumber);
        }

        Cell[] cells = new Cell[9];
        int j = 0;
        for (String numberString : numberStrings) {
            int number = ConsoleUtil.parseSudokuNumber(numberString);
            if (number == -1) {
                System.out.println("Invalid value detected: " + numberString + ". Input the row again.");
                readSudokuRow(rowNumber);
            }

            Cell cell = new Cell(rowNumber, j, number);
            cells[j] = cell;
            j++;
        }

        return cells;
    }

    private static int parseSudokuNumber(String numberString) {
        int number = -1;
        try {
            number = Integer.parseInt(numberString);
            if (number < 0 || number > 9) {
                number = -1;
            }
        } catch (NumberFormatException ignore) {
        }

        return number;
    }
}
