package net.remyang.leetcode;
import java.util.*;

public class GrayCode {

	public static void main(String[] args) {
		GrayCode c = new GrayCode();
		List<Integer> l = c.grayCode(4);
		for(int i:l){
			System.out.println(i);
		}
		System.out.println("*** " + l.size() + " ***");
	}
	
    public List<Integer> grayCode(int n) {
        if (n==0){ return Arrays.asList(0); }
        
        List<Integer> ret = new ArrayList<Integer>(grayCode(n-1));
        int m = 1 << (n-1);
        for(int j=ret.size()-1;j>=0;j--){
        	ret.add(ret.get(j)|m);
        }
        
        return ret;
    }
}
