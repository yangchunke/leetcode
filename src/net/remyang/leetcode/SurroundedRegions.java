package net.remyang.leetcode;

import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/surrounded-regions/
 *
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by
 * 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * For example, 
 * 
 * X X X X 
 * X O O X 
 * X X O X 
 * X O X X 
 * 
 * After running your function, the
 * board should be:
 * 
 * X X X X 
 * X X X X 
 * X X X X 
 * X O X X
 */
public class SurroundedRegions {

	public static void main(String[] args) {
		SurroundedRegions c = new SurroundedRegions();
		char[][] cc = new char[][] { { 'X', 'O', 'X' }, { 'X', 'O', 'X' },
				{ 'X', 'O', 'X' } };
		c.solve(cc);
		for (int i = 0; i < cc.length; i++) {
			for (int j = 0; j < cc[0].length; j++) {
				System.out.print(cc[i][j]);
			}
			System.out.println("");
		}
	}

	public void solve(char[][] board) {
		if (board.length == 0)
			return;
		int[][] marks = new int[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			mark(board, marks, i, 0);
			mark(board, marks, i, board[0].length - 1);
		}
		for (int j = 1; j < board[0].length - 1; j++) {
			mark(board, marks, 0, j);
			mark(board, marks, board.length - 1, j);
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'O' && marks[i][j] == 0) {
					board[i][j] = 'X';
				}
			}
		}
	}

	private void mark(char[][] board, int[][] marks, int x, int y) {
		Stack<Integer> X = new Stack<Integer>();
		Stack<Integer> Y = new Stack<Integer>();
		X.push(x);
		Y.push(y);
		while (!X.isEmpty()) {
			int xx = X.pop();
			int yy = Y.pop();
			if (xx < 0 || xx >= board.length || yy < 0 || yy >= board[0].length) {
				continue;
			} else if (board[xx][yy] == 'X') {
				continue;
			} else if (marks[xx][yy] == 0) {
				marks[xx][yy] = 1;
				X.push(xx + 1);
				Y.push(yy);
				X.push(xx - 1);
				Y.push(yy);
				X.push(xx);
				Y.push(yy + 1);
				X.push(xx);
				Y.push(yy - 1);
			}
		}
	}
}
