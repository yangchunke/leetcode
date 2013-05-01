/**
 * 
 */
package leetcode;

/**
 * http://leetcode.com/onlinejudge#question_6
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * 
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *
 */
public class ZigZagConversion {

    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuffer sb = new StringBuffer();
        int strLen = s.length();

        int delta0=(nRows-1)*2;
        int delta1=0;
        int[] deltas = new int[2];
        
        for(int row = 0; row<nRows; row++){
            int i = row;
            boolean firstDeltaIndex = true;
            
            deltas[0] = delta0==0?(delta1==0?1:delta1):delta0;
            deltas[1] = delta1==0?(delta0==0?1:delta0):delta1;
            
            while(i<strLen){                
                sb.append(s.charAt(i));                
                i += deltas[(firstDeltaIndex)?0:1];
                firstDeltaIndex = !firstDeltaIndex;
            }
            delta0 -= 2;
            delta1 += 2;
        }
        
        return sb.toString();
    }
}
