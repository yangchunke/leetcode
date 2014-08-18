package net.remyang.leetcode;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root!=null){
            _flatten(root, null);
        }
    }
    
    private TreeNode _flatten(TreeNode now, TreeNode lastVisited){
        
        if (lastVisited!=null)
        {
            lastVisited.left=null;
            lastVisited.right=now;
        }
        
        lastVisited = now;
        TreeNode left=now.left;
        TreeNode right=now.right;
        if (left!=null)
        	lastVisited = _flatten(left, lastVisited);
        if (right!=null)
            lastVisited = _flatten(right, lastVisited);
        
        return lastVisited;
    }
    
    private TreeNode _flatten1(TreeNode parent){
        
        TreeNode leftTail = parent;
        TreeNode rightTail = parent;
        
        if (parent.left!=null){
            rightTail = leftTail = _flatten1(parent.left);
        }

        if (parent.right!=null){
            rightTail = _flatten1(parent.right);
        }
        
        if (leftTail!=parent)
        {
            leftTail.right = parent.right;
            parent.right = parent.left;
            parent.left = null;
        }
        
        return rightTail;
    }
}
