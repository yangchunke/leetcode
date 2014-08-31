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
}
