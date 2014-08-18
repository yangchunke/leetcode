package net.remyang.leetcode;

public class LengthOfLastWord {

	public static void main(String[] args) {
		LengthOfLastWord c = new LengthOfLastWord();
		System.out.println(c.lengthOfLastWord("a "));
	}

	public int lengthOfLastWord(String s) {
        int ret = 0;
        boolean lastWordEncountered = false;
        for(int i=s.length()-1;i>=0;i--)
        {
            if (s.charAt(i)==' ')
            {
                if (lastWordEncountered) break;
            }
            else
            {
                lastWordEncountered = true;
                ret++;
            }
        }
        return ret;
    }

}
