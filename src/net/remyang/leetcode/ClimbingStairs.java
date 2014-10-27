package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/climbing-stairs/
 * 
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 */
public class ClimbingStairs {

	public static void main(String[] args) {
		ClimbingStairs c = new ClimbingStairs();
		for (int n = 0; n < 10; n++) {
			System.out.println(n + ": " + c.climbStairs(n));
		}
	}

	public int climbStairs(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		int prevprev = 1;
		int prev = 2;
		int now = 0;
		for (int i = 2; i < n; i++) {
			now = prev + prevprev;
			prevprev = prev;
			prev = now;
		}
		return now;
	}

}
