package net.remyang.leetcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utilities {

	private static int[] emptyIntArray = new int[] {};

	public static int[] arrayFromFile(String fileName) {
		try {
			String[] array = readFile(fileName).trim().split(",");
			int[] intArray = new int[array.length];
			for (int i = 0; i < array.length; i++) {
				intArray[i] = Integer.parseInt(array[i]);
			}
			return intArray;
		} catch (IOException e) {
		}

		return emptyIntArray;
	}

	private static String readFile(String file) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		StringBuilder stringBuilder = new StringBuilder();
		String ls = System.getProperty("line.separator");

		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line);
			stringBuilder.append(ls);
		}
		reader.close();

		return stringBuilder.toString();
	}
}
