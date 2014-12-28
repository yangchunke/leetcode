package net.remyang.leetcode;

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		ExcelSheetColumnTitle cc = new ExcelSheetColumnTitle();
		ExcelSheetColumnNumber c = new ExcelSheetColumnNumber();
		for (int i = 1; i < 100; i += 7) {
			System.out.println(i + " " + c.titleToNumber(cc.convertToTitle(i)));
		}
	}

	public int titleToNumber(String s) {
		int ret = 0;
		for (int i = 0; i < s.length(); i++) {
			ret *= 26;
			ret += (s.charAt(i) - 'A' + 1);
		}
		return ret;
	}
}
