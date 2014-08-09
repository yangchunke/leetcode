package leetcode;

import java.util.Stack;

public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestRectangleInHistogram c = new LargestRectangleInHistogram();
		System.out.println(c.largestRectangleArea(new int[]{1}));
		System.out.println(c.largestRectangleArea(new int[]{2,1,2}));
		System.out.println(c.largestRectangleArea(new int[]{0,1,0,1}));
	}

    public int largestRectangleArea(int[] height) {
        Stack<Integer> posStack = new Stack<Integer>();
        int maxArea = 0;
        for(int i=0; i<height.length; i++)
        {
            while(!posStack.empty() && height[posStack.peek()]>height[i])
            {
                int v = _pop(posStack, height, i);
                if (v>maxArea){
                    maxArea = v;
                }
            }
            if(posStack.empty() || height[posStack.peek()]<=height[i])
                posStack.push(i);
        }

        while(!posStack.empty())
        {
            int v = _pop(posStack, height, height.length);
            if (v>maxArea){
                maxArea = v;
            }
        }

        return maxArea;		
    }
    
    private int _pop(Stack<Integer> posStack, int[] height, int upper)
    {
        int poppedIndex = posStack.pop();
        int leftIndex = -1;
        
        while(!posStack.empty() && height[posStack.peek()]==height[poppedIndex])
        {
            posStack.pop();
        }
        
        if(!posStack.empty())
        {
            leftIndex = posStack.peek();
        }
        
        return (upper-leftIndex-1)*height[poppedIndex];
    }
}
