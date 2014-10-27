package net.remyang.leetcode;

import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/largest-rectangle-in-histogram/
 * 
 *         Given n non-negative integers representing the histogram's bar height
 *         where the width of each bar is 1, find the area of largest rectangle
 *         in the histogram.
 * 
 * 
 *         Above is a histogram where width of each bar is 1, given height =
 *         [2,1,5,6,2,3].
 * 
 * 
 *         The largest rectangle is shown in the shaded area, which has area =
 *         10 unit.
 * 
 *         For example, Given height = [2,1,5,6,2,3], return 10.
 */
public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		LargestRectangleInHistogram c = new LargestRectangleInHistogram();
		System.out.println(c.largestRectangleArea(new int[] { 1 }));
		System.out.println(c.largestRectangleArea(new int[] { 2, 1, 2 }));
		System.out.println(c.largestRectangleArea(new int[] { 0, 1, 0, 1 }));
	}

	public int largestRectangleArea(int[] height) {
		Stack<Integer> posStack = new Stack<Integer>();
		int maxArea = 0;
		for (int i = 0; i < height.length; i++) {
			while (!posStack.empty() && height[posStack.peek()] > height[i]) {
				int v = _pop(posStack, height, i);
				if (v > maxArea) {
					maxArea = v;
				}
			}
			if (posStack.empty() || height[posStack.peek()] <= height[i])
				posStack.push(i);
		}

		while (!posStack.empty()) {
			int v = _pop(posStack, height, height.length);
			if (v > maxArea) {
				maxArea = v;
			}
		}

		return maxArea;
	}

	private int _pop(Stack<Integer> posStack, int[] height, int upper) {
		int poppedIndex = posStack.pop();
		int leftIndex = -1;

		while (!posStack.empty()
				&& height[posStack.peek()] == height[poppedIndex]) {
			posStack.pop();
		}

		if (!posStack.empty()) {
			leftIndex = posStack.peek();
		}

		return (upper - leftIndex - 1) * height[poppedIndex];
	}
}
