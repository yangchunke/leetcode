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

	public int canCompleteCircuit(int[] gas, int[] cost) {

		int available = 0;
		int all = 0;
		int localMaxIndex = -1;
		int globalMax = Integer.MIN_VALUE;
		int globalMaxIndex = -1;

		for (int i = 0; i < gas.length * 2; i++) {
			int ii = i % gas.length;
			all += gas[ii] - cost[ii];
			available += gas[ii] - cost[ii];
			if (available >= 0) {
				if (localMaxIndex == -1) {
					localMaxIndex = ii;
				}
				if (available > globalMax) {
					globalMax = available;
					globalMaxIndex = localMaxIndex;
				}
			} else {
				available = 0;
				localMaxIndex = -1;
			}
		}

		return all >= 0 ? globalMaxIndex : -1;
	}

	public int canCompleteCircuitON2(int[] gas, int[] cost) {

		for (int i = 0; i < gas.length; i++) {
			if (canReach(gas, cost, i)) {
				return i;
			}
		}

		return -1;
	}

	private boolean canReach(int[] gas, int[] cost, int start) {

		int available = gas[start] - cost[start];
		int now = start;

		while (available >= 0) {
			now = (now + 1) % gas.length;
			if (now == start) {
				break;
			}
			available += gas[now] - cost[now];
		}

		return available >= 0 && now == start;
	}
}
