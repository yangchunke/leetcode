package leetcode;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SumRootToLeaf {
    int _total = 0;
	public int sumNumbers(TreeNode root) {
		if (root!=null){
	        _sumNumbers(root,0);
	    }
	    return _total;
	}
	
	private void _sumNumbers(TreeNode node, int fromRoot){
	    int val = fromRoot*10 + node.val;
	    if (node.left==null&&node.right==null){
	        _total += val;
	    }
	    else {
    	    if (node.left!=null){
    	        _sumNumbers(node.left, val);
    	    }
    	    if (node.right!=null){
    	        _sumNumbers(node.right, val);
    	    }
	    }
	}
}
