package net.remyang.leetcode;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {

	public static void main(String[] args) {
		SubstringWithConcatenationOfAllWords c = new SubstringWithConcatenationOfAllWords();
		for(int i : c.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo","barr","wing","ding","wing"})){
			System.out.print(i + " ");
		}
		System.out.println("");		
		for(int i : c.findSubstring("barfoothefoobarman", new String[]{"foo","bar"})){
			System.out.print(i + " ");
		}		
		System.out.println("");
		for(int i : c.findSubstring("aaa", new String[]{"a","a"})){
			System.out.print(i + " ");
		}
		System.out.println("");
		for(int i : c.findSubstring("aaa", new String[]{"a","b"})){
			System.out.print(i + " ");
		}
		System.out.println("");
		for(int i : c.findSubstring("abaababbaba", new String[]{"ab","ba","ab","ba"})){
			System.out.print(i + " ");
		}
		System.out.println("");
	}
	
	public List<Integer> findSubstring(String S, String[] L) {
        
        List<Integer> ret = new ArrayList<Integer>();
        
        HashMap<String, Integer> L_Map = new HashMap<String, Integer>();
        for(int i=0;i<L.length;i++){
            if (L_Map.containsKey(L[i])){
                L_Map.put(L[i], L_Map.get(L[i])+1);
            }
            else {
                L_Map.put(L[i], 1);
            }
        }
        
        HashMap<String, Integer> S_Matched = new HashMap<String, Integer>();

        int s_start = 0;
        int s_now = s_start;
        int l_matched = 0;
        
        int l_len = L[0].length();
        int upper_now = S.length() - l_len;
        
        while(s_now<=upper_now)
        {
            // get a substring from S
            String now = S.substring(s_now, s_now + l_len);
            
            // check if it's in the set
            if (!L_Map.containsKey(now)){
                // no match, starting from the next segment
                l_matched = 0;
                s_start = s_start + 1;
                s_now = s_start;
                S_Matched.clear();
            }
            else
            {
                if (S_Matched.containsKey(now)){
                    boolean used = false;
                    
                    if (S_Matched.get(now)==L_Map.get(now)){
                        used = true;
                    }
                    
                    // there is a match. need to check if it's used
                    if (used){
                    	
                        // the string is already used, we need to move ahead
                        // until we pass the previous matched position.
                        String prev = S.substring(s_start, s_start+l_len);
                        while(!now.equals(prev)){
                            int prevVal = S_Matched.get(prev);
                            if (prevVal>1)
                            {
                                S_Matched.put(prev,prevVal-1);
                            }
                            else
                            {
                                S_Matched.remove(prev);
                            }
                            
                            l_matched--; // Decrease the number of matched strings
                            
                            s_start += l_len;
                            prev = S.substring(s_start, s_start+l_len);
                        }
                        
                        // move to the next segment
                        l_matched--;
                        s_start += l_len;
                    }
                    else{
                    	S_Matched.put(now, S_Matched.get(now)+1);
                    }
                }
                else
                {
                	S_Matched.put(now, 1);
                }
                
                // add the current matched string
                l_matched++;
                
                // if the number of matched strings reach the total number of L,
                // we add the start position to the list.
                if (l_matched==L.length){
                    ret.add(s_start);
                }
                
                // move to the next segment
                s_now += l_len;
            }
        }
        
        return ret;
    }		
}
