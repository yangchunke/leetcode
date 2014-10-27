package net.remyang.leetcode;

public class ValidNumber {

	public static void main(String[] args) {
		ValidNumber c = new ValidNumber();
		c.test(null,  false);
		c.test("", false);
		c.test("0", true);
		c.test(" .1 ", true);
		c.test(" 0.1 ", true);
		c.test("abc", false);
		c.test("0e", false);
		c.test("1 a", false);
		c.test(" 2e10 ", true);
		c.test(" -1. ", true);
		c.test(" -1.2e10 ", true);
		c.test(" . ", false);
		c.test(" .-4 ", false);
		c.test(".e1", false);
		c.test("+.8", true);
		c.test("6e6.5", false);	
		c.test("005047e+6", true);
		c.test("6+1", false);		
	}
	
	private void test(String s, boolean expected){
		System.out.println(this.isNumber(s) + " == " + expected);
	}

	
	public boolean isNumber(String s) {
		if (s==null) return false;
        s = s.toLowerCase().trim();
        if (s.length()==0) return false;
        
        boolean numberNeeded = true;
        boolean dotEncountered = false;
        boolean signEncountered = false;
        boolean eEncountered = false;
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c>='0'&&c<='9'){
                numberNeeded = false;
            }
            else
            {
                switch(c){
                	case '+':
                    case '-':
                        if (dotEncountered||signEncountered||!numberNeeded)
                        {
                            return false;
                        }
                        else
                        {
                            signEncountered=true;
                        }
                        break;
                    case '.':
                        if (dotEncountered||eEncountered)
                        {
                            return false;
                        }
                        else
                        {
                            dotEncountered = true;
                        }
                        break;
                    case 'e':
                        if (numberNeeded || eEncountered){
                            return false;
                        }
                        else
                        {
                            eEncountered = true;
                            numberNeeded = true;
                            signEncountered = false;
                            dotEncountered = false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        }
        return !numberNeeded;
    }	
}
