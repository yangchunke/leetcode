package leetcode;

public class ClimbingStairs {

	public static void main(String[] args) {
		ClimbingStairs c = new ClimbingStairs();
		for(int n=0;n<10;n++)
		{
			System.out.println(n + ": " + c.climbStairs(n));
		}
	}
    public int climbStairs(int n) {
        if (n<=0) return 0;
        if (n==1) return 1;
        if (n==2) return 2;
        
        int prevprev = 1;
        int prev = 2;
        int now = 0;
        for(int i=2;i<n;i++){
            now = prev + prevprev;
            prevprev = prev;
            prev = now;
        }
        return now;
    }

}
