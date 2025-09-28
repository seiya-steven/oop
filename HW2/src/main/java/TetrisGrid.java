//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
	boolean[][] grid;
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		int n = grid.length;
		int m = grid[0].length;

		for (int row = 0; row < n; row++) {
			if (isFullRow(row)) {
				for (int i = row; i >= 1; i--) {
					for (int j = 0; j < m; j++) {
						grid[i][j] = grid[i - 1][j];
					}
				}
				for (int j = 0; j < m; j++) {
					grid[0][j] = false;
				}
				row--;
			}
		}
	}
	
	private boolean isFullRow(int row) {
		int m = grid[0].length;

		for (int j = 0; j < m; j++) {
			if (!grid[row][j]) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return grid;
	}
}
