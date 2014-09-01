package net.remyang.leetcode;

public class PalindromePartitionII {

	public long cnt = 0;
	public static void main(String[] args) {
		PalindromePartitionII c = new PalindromePartitionII();
		long start = System.nanoTime();
		System.out.println(c.minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		System.out.println("elapses " + (System.nanoTime() - start));
		System.out.println("calls " + c.cnt);
	}
	
    public int minCut(String s) {
        int[][] cuts = new int[s.length()][s.length()];
        int[][] palin = new int[s.length()][s.length()];

        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                cuts[i][j]=-1;
                palin[i][j]=-1;
            }
            palin[i][i]=1;
        }
        
        return minCut(s, 0, s.length(), cuts, palin);
    }
    
    private int minCut(String s, int start, int end, int cuts[][], int palin[][]){
        if (cuts[start][end-1]==-1){            
            if (isPalindrome(s,start,end, palin)){
                cuts[start][end-1]=0;
            }
            else
            {
            	cuts[start][end-1]=end-1-start;
                for (int i=start+1;i<end;i++)
                {
                	if (isPalindrome(s, start, i, palin)){
                		int thisCuts = minCut(s, i, end, cuts, palin)+1;
                		if (thisCuts<cuts[start][end-1]){
                			cuts[start][end-1] = thisCuts;
                		}
                	}
                }
            }
        }
        
        return cuts[start][end-1];
    }
    
    private boolean isPalindrome(String s, int start, int end, int palin[][]){
    	if (start>=end) return true;
    	
    	if (palin[start][end-1]==-1){
    		if (s.charAt(start)!=s.charAt(end-1)){
				palin[start][end-1]=0;
			}
			else{
				palin[start][end-1]= isPalindrome(s, start+1, end-1, palin)?1:0;
			}
    		palin[end-1][start]=palin[start][end-1];
    	}
        
        return palin[start][end-1]==1;
    }

}
