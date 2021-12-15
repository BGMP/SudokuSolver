SudokuSolver
===

A 9x9 Sudoku solver made in Java, implementing fundamental backtracking.

## Packages & Classes
There are two main packages:
  * [sudoku](https://github.com/BGMP/SudokuSolver/tree/master/src/cl/bgmp/sudoku): Contains classes related to the Sodoku game.
    * [Cell](https://github.com/BGMP/SudokuSolver/blob/master/src/cl/bgmp/sudoku/Cell.java): Represents a cell in the Sudoku grid
    * [Sudoku](https://github.com/BGMP/SudokuSolver/blob/master/src/cl/bgmp/sudoku/Sudoku.java): Represents the entire Sudoku game.
  * [util](https://github.com/BGMP/SudokuSolver/tree/master/src/cl/bgmp/util): Utils package.
    * [ConsoleUtil](https://github.com/BGMP/SudokuSolver/blob/master/src/cl/bgmp/util/ConsoleUtil.java): Provides methods for reading from Console.

## Usage
You may just want to use this program via commandline, where you can input Sudokus manually calling `Sudoku.fromCommandLine()`
the following way:

### Input
```
0 0 3 0 0 0 0 0 0
0 0 0 0 5 0 0 0 0
0 0 0 0 0 0 4 0 0
0 0 0 0 0 0 0 0 0
0 2 0 0 0 0 0 0 0
0 0 0 0 0 0 0 4 0
0 0 0 0 0 0 0 0 0
0 0 0 0 7 0 0 0 0
0 0 0 0 0 0 0 0 0
```

### Output
```
X-----------------------X
| 1 4 3 | 2 6 7 | 5 8 9 |
| 2 6 8 | 4 5 9 | 1 3 7 |
| 5 7 9 | 1 3 8 | 4 2 6 |
|-----------------------|
| 3 1 4 | 5 2 6 | 7 9 8 |
| 6 2 7 | 8 9 4 | 3 1 5 |
| 8 9 5 | 7 1 3 | 6 4 2 |
|-----------------------|
| 4 3 2 | 6 8 5 | 9 7 1 |
| 9 5 1 | 3 7 2 | 8 6 4 |
| 7 8 6 | 9 4 1 | 2 5 3 |
X-----------------------X
```

Or you may want to solve a Sudoku represented by a classic 2d array:
```java
public interface Boards {
    int[][] SAMPLE_1 = {
            {0, 0, 3, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 5, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 4, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 4, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 7, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
}
```

You can load a Sudoku like that by calling `Sudoku.fromArray(your2DArray)`. This will return a Sudoku object, ready to
be solved.
