package net.remyang.leetcode;

public class UniquePathsII {

	public static void main(String[] args) {
		UniquePathsII c = new UniquePathsII();
		System.out.println(c.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] paths = new int[m][n];
        
        paths[0][0]= 1;
        
        for(int i=0; i<m; i++){
            int prevI = i - 1;
            for(int j=0; j<n; j++){
                int prevJ = j - 1;
                if (obstacleGrid[i][j]==1){
                	paths[i][j]=0;
                }
                else
                {
                    if (prevI>=0){
                    	paths[i][j] += paths[prevI][j];
                    }
                    if (prevJ>=0){
                    	paths[i][j] += paths[i][prevJ];
                    }
                }
            }
        }
        
        return paths[m-1][n-1];
    }	
}
