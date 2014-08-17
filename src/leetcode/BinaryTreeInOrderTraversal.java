package leetcode;
import java.util.*;

public class BinaryTreeInOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if (root!=null)
        {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            pushLeft(stack, root);
            while(!stack.isEmpty()){
                TreeNode now = stack.pop();
                ret.add(now.val);
                if (now.right!=null){
                    pushLeft(stack,now.right);
                }
            }
        }
        return ret;
    }
    
    private void pushLeft(Stack<TreeNode> stack, TreeNode node){
        while(node!=null){
            stack.push(node);
            node = node.left;
        }
    }

}
