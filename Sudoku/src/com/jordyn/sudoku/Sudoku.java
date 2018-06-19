package com.jordyn.sudoku;

public class Sudoku {

	private int[][] board;
	
	/**
	 * Empty constructor that initializes a 9x9 (empty) board
	 */
	public Sudoku() {
		this(new int[9][9]);
	}
	
	/**
	 * Constructor that takes a board argument and initializes the board to it
	 * 
	 * @param board
	 *            the initial board to use
	 */
	public Sudoku(int[][] board) {
		this.board = board;
	}
	
	private boolean rowContains(int row, int n) {
		for(int i = 0; i < 9; i++) {
			if(board[row][i] == n) {
				return true;
			}
		}
		return false;
	}
	
	private boolean colContains(int col, int n) {
		for(int i = 0; i < 9; i++) {
			if(board[i][col] == n) {
				return true;
			}
		}
		return false;
	}
	
	private boolean boxContains(int row, int col, int n) {
		int rBound = row - (row % 3);
		int cBound = col - (col % 3);
		for(int i = rBound; i < rBound + 3; i++) {
			for(int j = cBound; j < cBound + 3; j++) {
				if(board[i][j] == n) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isSafe(int row, int col, int n) {
		return !(rowContains(row, n) || colContains(col, n) || boxContains(row, col, n));
	}
	
	/**
	 * Solves the board
	 * 
	 * @return true if the board is solvable (and solved); false otherwise
	 */
	public boolean solve() {
		for(int i = 0; i < 9; i++) { // iterate through the rows...
			for(int j = 0; j < 9; j++) { // iterate through columns of the rows...
				if(board[i][j] == 0) { // if the square is unassigned...
					for(int k = 1; k <= 9; k++) { // try all of the numbers 1-9
						if(isSafe(i, j, k)) { // see if the number will legally fit in the square...
							board[i][j] = k; // if so, set the square to the number
							if(solve()) { // continue down that path and see if it all works out
								return true; // if the path all works out, the puzzle is solved
							} else {
								// if it doesn't all work out, set the square to 0 and try the next number on
								// next loop iteration
								board[i][j] = 0;
							}
						}
					}
					// reaching this condition means no numbers fit into the square and the puzzle
					// is unsolvable
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Prints the board
	 */
	public void printBoard() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(board[i][j]);
				if((j + 1) % 3 == 0 && j < 8) {
					System.out.print("|");
				}
			}
			System.out.println();
			if((i + 1) % 3 == 0 && i < 8) {
				System.out.println("-----------");
			}
		}
	}
	
}
