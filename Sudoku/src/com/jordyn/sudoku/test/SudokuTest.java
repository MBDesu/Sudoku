package com.jordyn.sudoku.test;

import org.junit.jupiter.api.Test;

import com.jordyn.sudoku.Sudoku;

class SudokuTest {

	private int[][] board = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 7, 0, 0, 0, 0, 3, 1 }, { 0, 0, 3, 0, 1, 0, 0, 0, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
			{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
			{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
	private Sudoku sudoku = new Sudoku(board);

	@Test
	public void testConstructor() {
		Sudoku s = new Sudoku(board);
		Sudoku t = new Sudoku();
		s.printBoard();
		t.printBoard();
	}

	@Test
	public void testSolve() {
		sudoku.solve();
		sudoku.printBoard();
	}

}
