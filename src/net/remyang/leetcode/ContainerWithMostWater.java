package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/container-with-most-water/
 *
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container.
 */
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int mostWater = 0;
		int start = 0;
		int end = height.length - 1;
		while (start < end) {
			if (height[start] < height[end]) {
				mostWater = Math.max(mostWater, height[start] * (end - start));
				int ns = start + 1;
				while (ns < end && height[ns] <= height[start]) {
					ns++;
				}
				start = ns;
			} else {
				mostWater = Math.max(mostWater, height[end] * (end - start));
				int ne = end - 1;
				while (ne > start && height[ne] <= height[end]) {
					ne--;
				}
				end = ne;
			}
		}
		return mostWater;
	}
}
