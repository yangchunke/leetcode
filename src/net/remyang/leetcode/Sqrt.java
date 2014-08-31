package net.remyang.leetcode;

public class Sqrt {

	public int sqrt(int x) {
        return _sqrt(x, 0, x);
    }
    
    private int _sqrt(int x, int s, int e){
        if (s>=e) return s;
        int m = s + (e-s)/2;
        long mm = m;
        mm*=m;
        if (mm==x){
            return m;
        }
        else if (mm>x) {
    		return _sqrt(x, s, m);
    	}
    	else
    	{
    		int n = _sqrt(x, m+1, e);
            long nn = n;
            nn *=n;
            return nn>x?m:n;
    	}
    }	
}
