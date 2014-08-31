package leetcode;
import java.util.*;

public class GrayCode {

	public static void main(String[] args) {
		GrayCode c = new GrayCode();
		List<Integer> ret = c.grayCode(3);
		for(int i: ret){
			System.out.println(i);
		}
	}

	public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        
        int val = 0;
        int endBits = n;
        while(endBits>0){
            int mask = 1;
            for(int i=0;i<endBits;i++){
                ret.add(val);
                val ^= mask;
                mask <<=1;
            }
            endBits--;
        }
        ret.add(val);
        
        return ret;
    }
}
