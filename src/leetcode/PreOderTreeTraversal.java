package leetcode;
import java.util.*;

public class PreOderTreeTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if (root!=null){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            
            while(!stack.isEmpty()){
                TreeNode now = stack.pop();
                ret.add(now.val);
                if (now.right!=null)
                    stack.push(now.right);
                if (now.left!=null)
                    stack.push(now.left);
            }
        }
        
        return ret;
    }
}
