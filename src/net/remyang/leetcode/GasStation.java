package net.remyang.leetcode;

public class GasStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
        
        for(int i=0;i<gas.length;i++){
            if (canReach(gas, cost, i)){
                return i;
            }
        }
        
        return -1;
    }
    
    private boolean canReach(int[] gas, int[] cost, int start){
        
        int available = gas[start]-cost[start];
        int now = start;
        
        while(available>=0)
        {
            now = (now+1)%gas.length;
            if (now==start){
                break;
            }
            available += gas[now] - cost[now];
        }
        
        return available>=0 && now==start;
    }	
}
