package leetcode;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int lengthOfLongestSubstring(String s) {
        
        int max = 0;
        int start = 0;
        int positions[] = new int[256];
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (positions[c]!=0){
                
                // update the max length
                int len = i-start;
                if (len>max){
                    max=len;
                }
                
                // clean up the positions from start to positions[c]
                for(;start<positions[c];start++){
                    positions[s.charAt(start)]=0;
                }
            }
            positions[c] = i+1;
        }
        
        int last = s.length()-start;
        return Math.max(max, last);
    }

}
