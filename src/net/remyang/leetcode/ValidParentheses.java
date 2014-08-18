package net.remyang.leetcode;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c=='}'){
                if (!match(stack, '{')){
                    return false;
                }
            }
            else if (c==')'){
                if (!match(stack, '(')){
                    return false;
                }
            }
            else if (c==']'){
                if (!match(stack, '[')){
                    return false;
                }
            }
            else
            	stack.push(c);
        }        
        return stack.isEmpty();
    }
    
    private boolean match(Stack<Character> stack, char lookFor){
        if (stack.isEmpty() || stack.peek()!=lookFor){
            return false;
        }
        stack.pop();
        return true;
    }

}
