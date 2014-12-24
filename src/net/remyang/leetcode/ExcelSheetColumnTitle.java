package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/excel-sheet-column-title/
 *
 *         Given a positive integer, return its corresponding column title as
 *         appear in an Excel sheet.
 * 
 *         For example: 1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB
 */
public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		ExcelSheetColumnTitle c = new ExcelSheetColumnTitle();
		System.out.println(c.convertToTitle(1));
		System.out.println(c.convertToTitle(25));
		System.out.println(c.convertToTitle(26));
		System.out.println(c.convertToTitle(27));
		System.out.println(c.convertToTitle(28));
		System.out.println(c.convertToTitle(52));
		System.out.println(c.convertToTitle(53));
		System.out.println(c.convertToTitle(54));
	}

	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			n -= 1;
			sb.insert(0, (char) ('A' + n % 26));
			n /= 26;
		}
		return sb.toString();
	}

}
