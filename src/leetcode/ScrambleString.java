package leetcode;

public class ScrambleString {

	public static void main(String[] args) {
		ScrambleString c = new ScrambleString();
		System.out.println(c.isScramble("abab", "abab"));
	}
	
	public boolean isScramble(String s1, String s2) {
        int[][][][] flags = new int[s1.length()][s1.length()][s2.length()][s2.length()];
        return _isScramble(flags, s1, s2, 0, s1.length(), 0, s2.length());
    }
    
    private boolean _isScramble(int[][][][] flags, String s1, String s2, int s1Start, int s1End, int s2Start, int s2End){
        int delta = s1End - s1Start;
        
        if (delta==0){
            return true;
        }
        else if (delta==1){
            return s1.charAt(s1Start)==s2.charAt(s2Start);
        }
        
        if (flags[s1Start][s1End-1][s2Start][s2End-1]==0){
            flags[s1Start][s1End-1][s2Start][s2End-1] = -1;
            for(int i=1;i<delta;i++){
                int _s1Separator = s1Start + i;
                int _s2Separator = s2Start + i;
                
                if (_isScramble(flags, s1, s2, s1Start, _s1Separator, s2Start, _s2Separator)
                && _isScramble(flags, s1, s2, _s1Separator, s1End, _s2Separator, s2End))
                {
                    flags[s1Start][s1End-1][s2Start][s2End-1] = 1;
                    break;
                }
                
                _s2Separator = s2End -i;
                if (_isScramble(flags, s1, s2, s1Start, _s1Separator, _s2Separator, s2End)
                && _isScramble(flags, s1, s2, _s1Separator, s1End, s2Start, _s2Separator))
                {
                    flags[s1Start][s1End-1][s2Start][s2End-1] = 1;
                    break;
                }
            }
        }
        
        return flags[s1Start][s1End-1][s2Start][s2End-1]==1;
    }	

}
