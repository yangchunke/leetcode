package net.remyang.leetcode;

public class AddBinary {

	public static void main(String[] args) {
		AddBinary c = new AddBinary();
		System.out.println(c.addBinary("11", ""));
	}

	public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        boolean carried = false;
        for(int i=a.length()-1,j=b.length()-1;
            i>=0||j>=0;
            i--,j--)
            {
                boolean aV = i>=0?(a.charAt(i)=='1'):false;
                boolean bV = j>=0?(b.charAt(j)=='1'):false;
                
                boolean nV;
                if (aV!=bV){
                    // a | b | c | -> n | c
                    // --------------------
                    // 1 | 0 | 0 | -> 1 | 0
                    // 1 | 0 | 1 | -> 0 | 1
                    // 0 | 1 | 0 | -> 1 | 0
                    // 0 | 1 | 1 | -> 0 | 1
                    nV = !carried;
                }
                else
                {
                    // a | b | c | -> n | c
                    // --------------------
                    // 0 | 0 | 0 | -> 0 | 0
                    // 0 | 0 | 1 | -> 1 | 0
                    // 1 | 1 | 0 | -> 0 | 1
                    // 1 | 1 | 1 | -> 1 | 1
                    nV=carried;
                    carried = aV;
                }
                
                sb.append(nV?'1':'0');
            }
        if(carried){
            sb.append('1');
        }
        return sb.reverse().toString();
    }	
}
