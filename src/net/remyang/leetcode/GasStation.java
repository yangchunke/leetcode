package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/gas-station/
 *
 * There are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit
 * once, otherwise return -1.
 * 
 * Note: The solution is guaranteed to be unique.
 */
public class GasStation {

	public static void main(String[] args) {
		GasStation c = new GasStation();
		System.out.println(c.canCompleteCircuit(new int[] { 2, 4 }, new int[] {
				3, 4 }));
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int start = 0;
		int tank = 0;
		int curr = start;
		while (true) {
			tank += gas[curr] - cost[curr];
			curr = (curr + 1) % gas.length;
			if (tank < 0) {
				if (curr <= start) {
					start = -1;
					break;
				}
				start = curr;
				tank = 0;
			} else {
				if (curr == start) {
					break;
				}
			}
		}
		return start;
	}

}
