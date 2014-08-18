package net.remyang.leetcode;
import java.util.*;

public class BinaryTreePostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        
        if (root!=null)
        {
			Stack<TreeNode> stack = new Stack<TreeNode>();

            stack.push(root);
            
            while(!stack.isEmpty()){
                
                TreeNode now = stack.pop();
                ret.add(0,now.val);
                
                if (now.left!=null){
                    stack.push(now.left);
                }
                if (now.right!=null){
                    stack.push(now.right);
                }
            }
        }
        
        return ret;
    }
}
