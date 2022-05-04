package u10pp;
import java.util.List;

public class SudokuSolver{

    // declare variables
    // numRow can be used as size
    static int numRow;
    static int numCol;
    static int [][] solvedPuzzle;
    static boolean pass;
    

    // create solve function that returns the solved puzzle
    public static int[][] solve(int[][] puzzle) {

        // declare 1x1 solved array. 
        // Ex: [1]
        int[][] oneByOne = new int[1][1];
        oneByOne[0][0] = 1;

        // initiate row and col variables
        // set solved puzzle to the puzzle in sudokuPuzzlesTests.txt
        numRow = puzzle.length;
        numCol = puzzle[0].length;
        solvedPuzzle = puzzle;

        // if puzzle is 1x1 then return [1]
        // else solve normally
        if (numRow == 1 && numCol == 1) {
            return oneByOne;
        } else if (tempFunc(solvedPuzzle, 0, 0)) {
            return solvedPuzzle;
        }

        
        // create empty array
        int[][] stupid = new int[1][1];
        // return empty array since the function wont work without it
        return stupid;
        
    }

    // bruh moment
    public static boolean tempFunc(int solvedPuzzle[][], int row, int col) {
        if (row == numRow - 1 && col == numRow)
			return true;

		if (col == numRow) {
			row++;
			col = 0;
		}

		if (solvedPuzzle[row][col] != 0)
			return tempFunc(solvedPuzzle, row, col + 1);

		for (int num = 1; num < 10; num++) {
			if (isSafe(solvedPuzzle, row, col, num)) {
				solvedPuzzle[row][col] = num;

				if (tempFunc(solvedPuzzle, row, col + 1))
					return true;
			}
			solvedPuzzle[row][col] = 0;
		}
		return false;
    }


	// Print puzzle function
	static void print(int[][] solvedPuzzle)
	{
		for (int i = 0; i < numRow; i++) {
			for (int j = 0; j < numRow; j++)
				System.out.print(solvedPuzzle[i][j] + " ");
			System.out.println();
		}
	}

    // function that checks if spot is eligible for a number
	static boolean isSafe(int[][] solvedPuzzle, int row, int col, int num)
	{
        // check row first 
		for (int x = 0; x <= (numRow - 1); x++)
			if (solvedPuzzle[row][x] == num)
				return false;
        
        // check column second
		for (int x = 0; x <= (numRow - 1); x++)
			if (solvedPuzzle[x][col] == num)
				return false;


        // Check the NxN unit third
        // Check an even sized unit
        if (solvedPuzzle.length % 2 == 0) {
		int startRow = row - row % 2, startCol = col - col % 2;
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 2; j++)
				if (solvedPuzzle[i + startRow][j + startCol] == num)
					return false;
        }

        // check an odd sized unit 
        else if (solvedPuzzle.length % 3 == 0) {
		int startRow = row - row % 3, startCol = col - col % 3;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (solvedPuzzle[i + startRow][j + startCol] == num)
					return false;
        }
		return true;
	}

}