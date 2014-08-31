package net.remyang.leetcode;

import java.util.Stack;

public class ReversePolistNotation {

	public static void main(String[] args) {
		ReversePolistNotation c = new ReversePolistNotation();
		System.out.println(c.evalRPN(new String[]{"0","3","/"}));
	}
    public int evalRPN(String[] tokens) {
        Stack<Integer> values = new Stack<Integer>();
        for(int i=0;i<tokens.length;i++){
            String token = tokens[i];
            if (token.equals("+")){
                add(values, values.pop(),values.pop());
            }
            else if (token.equals("-")){
                sub(values, values.pop(),values.pop());
            }
            else if (token.equals("*")){
                mul(values, values.pop(),values.pop());
            }
            else if (token.equals("/")){
                div(values, values.pop(),values.pop());
            }
            else
            {
                values.push(Integer.parseInt(token));
            }
        }
        return values.pop();
    }
    
    private void add(Stack<Integer> values, int o1, int o2){
        values.push(o1+o2);
    }
    private void sub(Stack<Integer> values, int o1, int o2){
        values.push(o2-o1);
    }
    private void mul(Stack<Integer> values, int o1, int o2){
        values.push(o1*o2);
    }
    private void div(Stack<Integer> values, int o1, int o2){
        values.push(o2/o1);
    }

}
