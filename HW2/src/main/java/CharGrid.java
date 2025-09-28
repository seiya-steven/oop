// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		int n = grid.length;
		int m = grid[0].length;
		
		int l = m, t = n;
		int r = -1, b = -1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == ch) {
					l = Math.min(l, j);
					r = Math.max(r, j);
					t = Math.min(t, i);
					b = Math.max(b, i);
				}
			}
		}

		return r == -1 ? 0 : (r - l + 1) * (b - t + 1);
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		int n = grid.length;
		int m = grid[0].length;

		int count = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int left = countLength(i, j, 0, -1);
				int right = countLength(i, j, 0, 1);
				int up = countLength(i, j, -1, 0);
				int down = countLength(i, j, 1, 0);

				int minLength = Math.min(Math.min(left, right), Math.min(up, down));

				if (minLength >= 2 && left == right && up == down && left == up) {
					count++;
				}
			}
		}

		return count;
	}
	
	private int countLength(int row, int col, int dr, int dc) {
		char ch = grid[row][col];
		int length = 0;
		int n = grid.length;
		int m = grid[0].length;

		while (row < n && row >= 0 && col < m && col >= 0 && grid[row][col] == ch) {
			length++;
			row += dr;
			col += dc;
		}

		return length;
	}

	public static void main(String[] args) {
		// char[][] arr = new char[][] {
		// 	{'a', 'b', 'c', 'd'},
		// 	{'a', ' ', 'c', 'b'},
		// 	{'x', 'b', 'c', 'a'}
		// };
		char[][] arr = new char[][] {
			{' ', ' ', 'p', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', 'p', ' ', ' ', ' ', ' ', 'x', ' '},
			{'p', 'p', 'p', 'p', 'p', ' ', 'x', 'x', 'x'},
			{' ', ' ', 'p', ' ', ' ', 'y', ' ', 'x', ' '},
			{' ', ' ', 'p', ' ', 'y', 'y', 'y', ' ', ' '},
			{'z', 'z', 'z', 'z', 'z', 'y', 'z', 'z', 'z'},
			{' ', ' ', 'x', 'x', ' ', 'y', ' ', ' ', ' '}
		};
		CharGrid grid = new CharGrid(arr);
		System.out.println(grid.charArea('c'));
	}
}
