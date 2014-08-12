package leetcode;

public class BuyAndSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class Solution {
	    public int maxProfit(int[] prices) {
	        int globalMax=0;
	        int localMax=0;
	        int runningProfit = 0;

	        for(int i=1;i<prices.length;i++){
	            runningProfit += prices[i] - prices[i-1];
	            if (runningProfit>localMax){
	                localMax=runningProfit;
	            }
	            else if(runningProfit<0){
	                if (localMax>globalMax){
	                    globalMax = localMax;
	                }
	                localMax = 0;
	                runningProfit = 0;
	            }
	        }
	        
	        return localMax>globalMax?localMax:globalMax;
	    }
	}
	
}
