
public class sudokuSolver {
	
	private static final int GRID_SIZE = 9;
	
	public static void main (String[] args) {
		int[][] sudokuBoard = {
				{7, 0, 2, 0, 5, 0, 6, 0, 0},
				{0, 0, 0, 0, 0, 3, 0, 0, 0},
				{1, 0, 0, 0, 0, 9, 5, 0, 0},
				{8, 0, 0, 0, 0, 0, 0, 9, 0},
				{0, 4, 3, 0, 0, 0, 7, 5, 0},
				{0, 9, 0, 0, 0, 0, 0, 0, 8},
				{0, 0, 9, 7, 0, 0, 0, 0, 5},
				{0, 0, 0, 2, 0, 0, 0, 0, 0},
				{0, 0, 7, 0, 4, 0, 2, 0, 3}
		};

	if(solveTheBoard(sudokuBoard)) {
			System.out.println("Sudoku has been solved successfully");
		} else {
			System.out.println("It is impossible to solve this board. We are really sorry");
		}

	printTheBoard(sudokuBoard);
		
	}

	private static void printTheBoard(int[][] sudokuBoard) {
		for(int row = 0; row < GRID_SIZE; row++) {
			for(int column = 0; column < GRID_SIZE; column++) {
				System.out.print(sudokuBoard[row][column]);
			}
			System.out.println();
		}
	}

	private static boolean isNumberInRow(int[][] sudokuBoard, int number, int row) {
		for (int i = 0; i < GRID_SIZE; i++)  {
			if(sudokuBoard[row][i] == number) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isNumberInColumn(int[][] sudokuBoard, int number, int column) {
		for (int i = 0; i < GRID_SIZE; i++)  {
			if(sudokuBoard[i][column] == number) {
				return true;
			}
		}
		return false;
	}

	private static boolean isNumberInBox(int[][] sudokuBoard, int number, int row, int column) {
		int boxRow = row - row % 3;
		int boxColumn = column - column % 3;
		for (int i = boxRow; i < boxRow + 3; i++)  {
			for(int j = boxColumn; j < boxColumn + 3; j++) {
				if(sudokuBoard[i][j] == number) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isPlacementValid(int[][] sudokuBoard, int number, int row, int column) {
		return !isNumberInRow(sudokuBoard, number, row) && !isNumberInColumn(sudokuBoard, number, column)
				&& !isNumberInBox(sudokuBoard, number, row, column);
	}

	private static boolean solveTheBoard(int[][] sudokuBoard) {
		for (int row = 0; row < GRID_SIZE; row++)  {
			for (int column = 0; column < GRID_SIZE; column++)  {
				if(sudokuBoard[row][column] == 0) {
					for(int givenNumber = 1; givenNumber <= GRID_SIZE; givenNumber++) {
						if(isPlacementValid(sudokuBoard, givenNumber, row, column)) {
							sudokuBoard[row][column] = givenNumber;
							
							if(solveTheBoard(sudokuBoard)) {
								return true;
							} else {
								sudokuBoard[row][column] = 0;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}
}
