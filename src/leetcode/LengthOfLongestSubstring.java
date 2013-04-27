/**
 * 
 */
package leetcode;

/**
 * http://leetcode.com/onlinejudge#question_3
 * 
 * Given a string, find the length of the longest substring without repeating characters. 
 * 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 *
 */
public class LengthOfLongestSubstring {
	
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	
        int length = s.length();    	
    	java.util.Set<Character> positions = new java.util.HashSet<Character>();    	
    	int globalMaxLength = 0;    	
    	int localMaxLength = 0;
    	int now=0;
    	
    	while(now < length){
    		char nowChar = s.charAt(now);
    		if (positions.contains(nowChar)){    			
    			
    	    	if (localMaxLength>globalMaxLength){
    	    		globalMaxLength = localMaxLength;
    	    	}
    	    	
                positions.clear();
                                
                localMaxLength = 0;
    	    	int lastPosition = now;
                char lastChar = s.charAt(lastPosition);
                while(!positions.contains(lastChar))
                {
                    positions.add(lastChar);
                    localMaxLength++;
                    lastChar = s.charAt(--lastPosition);
                }
    		}else{
    			positions.add(nowChar);
    			localMaxLength++;
    		}
            now++;
    	}
    	
    	if (localMaxLength>globalMaxLength){
    		globalMaxLength = localMaxLength;
    	}
    	
        return globalMaxLength;
    }
}
