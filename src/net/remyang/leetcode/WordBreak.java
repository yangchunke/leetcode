/**
 * 
 */
package net.remyang.leetcode;

import java.util.Set;

/**
 * @author chunkeya
 *
 */
public class WordBreak {
	
	public boolean wordBreak(String s, Set<String> dict) {
		short used[] = new short[s.length()];
		for(int i=0;i<s.length();i++){
		    used[i]=0;
		}
		return this.canBreak(s, 0, dict, used);
    }
	
	private boolean canBreak(String s, int offset, Set<String> dict, short[] used){
	    
    	if (offset==s.length()){return true;}
	    
	    if(used[offset]==0){
    		for(String k : dict){
    			if (s.startsWith(k, offset)){
    				if (this.canBreak(s, offset+k.length(), dict, used))
    				{
    				    used[offset]=1;
    				    return true;
    				}
    			}
    		}
    	    used[offset] = -1;
    	    return false;
	    }
	    
		return used[offset]==1?true:false;
	}
}
