package net.remyang.leetcode;

import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/min-stack/
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

	push(x) -- Push element x onto stack.
	pop() -- Removes the element on top of the stack.
	top() -- Get the top element.
	getMin() -- Retrieve the minimum element in the stack.
	
 *
 */
public class MinStack {

	Stack<Integer> fullStack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();

	public void push(int x) {
		fullStack.push(x);
		if (minStack.empty() || x <= minStack.peek()) {
			minStack.push(x);
		}
	}

	public void pop() {
		if (!fullStack.empty()) {
			int x = fullStack.peek();
			if (x <= minStack.peek()) {
				minStack.pop();
			}
			fullStack.pop();
		}
	}

	public int top() {
		return fullStack.empty() ? 0 : fullStack.peek();
	}

	public int getMin() {
		return minStack.empty() ? 0 : minStack.peek();
	}
}
