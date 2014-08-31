package net.remyang.leetcode;

public class UniquePaths {

	public static void main(String[] args) {
		UniquePaths c = new UniquePaths();
		System.out.println(c.uniquePaths(1,1));
		System.out.println(c.uniquePaths(1,2));
		System.out.println(c.uniquePaths(2,1));
		System.out.println(c.uniquePaths(2,2));
	}

    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];

        
        for(int i=0;i<m;i++){
        	paths[i][0] = 1;
        }
        for(int j=0;j<n;j++){
        	paths[0][j] = 1;
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                paths[i][j] += paths[i-1][j] + paths[i][j-1];
            }
        }
        
        return paths[m-1][n-1];
    }
}
