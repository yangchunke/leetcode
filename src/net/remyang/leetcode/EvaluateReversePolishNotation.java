package net.remyang.leetcode;

import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/evaluate-reverse-polish-notation/
 *
 *         Evaluate the value of an arithmetic expression in Reverse Polish
 *         Notation.
 * 
 *         Valid operators are +, -, *, /. Each operand may be an integer or
 *         another expression.
 * 
 *         Some examples: 
 *         
 *         ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 
 *         ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		EvaluateReversePolishNotation c = new EvaluateReversePolishNotation();
		System.out.println(c.evalRPN(new String[] { "0", "3", "/" }));
	}

	public int evalRPN(String[] tokens) {
		Stack<Integer> values = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			String token = tokens[i];
			if (token.equals("+")) {
				add(values, values.pop(), values.pop());
			} else if (token.equals("-")) {
				sub(values, values.pop(), values.pop());
			} else if (token.equals("*")) {
				mul(values, values.pop(), values.pop());
			} else if (token.equals("/")) {
				div(values, values.pop(), values.pop());
			} else {
				values.push(Integer.parseInt(token));
			}
		}
		return values.pop();
	}

	private void add(Stack<Integer> values, int o1, int o2) {
		values.push(o1 + o2);
	}

	private void sub(Stack<Integer> values, int o1, int o2) {
		values.push(o2 - o1);
	}

	private void mul(Stack<Integer> values, int o1, int o2) {
		values.push(o1 * o2);
	}

	private void div(Stack<Integer> values, int o1, int o2) {
		values.push(o2 / o1);
	}

}
