
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

}
