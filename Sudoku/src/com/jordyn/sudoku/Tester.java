package com.jordyn.sudoku;

public class Tester { 

	public static void main(String[] args) {
		
		int[][] board = {{ 3, 0, 6, 5, 0, 8, 4, 0, 0 },
				         { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
				         { 0, 0, 7, 0, 0, 0, 0, 3, 1 },
				         { 0, 0, 3, 0, 1, 0, 0, 0, 0 },
				         { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				         { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				         { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
				         { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
				         { 0, 0, 5, 2, 0, 6, 3, 0, 0 }};
		Sudoku s = new Sudoku(board);
		System.out.println("Original: ");
		s.printBoard();
		System.out.println();
		if(s.solve()) {
			System.out.println("Solved: ");
			s.printBoard();
		} else {
			System.out.println("No solutions!");
		}
		
	}
	
}
