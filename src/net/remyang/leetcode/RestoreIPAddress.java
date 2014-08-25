package net.remyang.leetcode;
import java.util.*;

public class RestoreIPAddress {

	public static void main(String[] args) {
		RestoreIPAddress c = new RestoreIPAddress();

		for(String s : c.restoreIpAddresses("010010")){
			System.out.println(s);
		}

	}
	public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<String>();
        String[] partial = new String[4];
        restoreIpAddresses(s, 0, 4, partial, ret);
        return ret;
    }
    
    private void restoreIpAddresses(String s, int start, int parts, String[] partial, List<String> ret){
        
        int len = s.length()-start;
        
        if (len<parts || len>(parts*3)){
            return;
        }
        
        if (parts==0){
            ret.add(String.format("%s.%s.%s.%s",partial[0],partial[1],partial[2],partial[3]));
            return;
        }
        
        for(int i=1,end=start+i;i<=3&&end<=s.length();i++,end++){
            String ss = s.substring(start,end);
            if (isValid(ss)){
                partial[4-parts] = ss;
                restoreIpAddresses(s, end, parts-1, partial, ret);
            }
        }
    }
    
    
    private boolean isValid(String s){
    	if (s.length()>1&&s.charAt(0)=='0') return false;
        int v = Integer.parseInt(s);
        return (v>=0&&v<=255);
    }
}
