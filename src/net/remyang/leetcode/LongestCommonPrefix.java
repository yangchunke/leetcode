package net.remyang.leetcode;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String longestCommonPrefix(String[] strs) {
        if (strs.length==0) return "";
        if (strs.length==1) return strs[0];
        
        StringBuilder sb = new StringBuilder();
        
        int j=0;
        boolean match=true;
        while(j<strs[0].length()&&match)
        {
            char c = strs[0].charAt(j);
            for(int i=1;i<strs.length;i++)
            {
                String s = strs[i];
                if (j>=s.length() || c!=s.charAt(j)){
                    match = false;
                    break;
                }
            }
            
            if (match){
                sb.append(c);
            }
            
            j++;
        }
        
        return sb.toString();
    } 	
}
