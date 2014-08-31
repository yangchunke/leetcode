package net.remyang.leetcode;

public class BinaryTreeMaximumPathSum {
	
	public static void main(String[] args){
		TreeNode tn = 
		new TreeNode(5, 
				new TreeNode(4, 
						new TreeNode(11, 
								new TreeNode(7), 
								new TreeNode(2)),
						null),
				new TreeNode(8,
						new TreeNode(13),
						new TreeNode(4,
								null,
								new TreeNode(1))));
		
		TreeNode tn2 =
		new TreeNode(-2,
				new TreeNode(6,
						new TreeNode(0),
						new TreeNode(-6)),
				null);
		
		TreeNode tn3 =
		new TreeNode(-6,
				null,
				new TreeNode(3,
						new TreeNode(2),
						null));
		BinaryTreeMaximumPathSum c = new BinaryTreeMaximumPathSum();
		System.out.println(c.maxPathSum(tn));
		System.out.println(c.maxPathSum(tn2));
		System.out.println(c.maxPathSum(tn3));
	}
	
	public int maxPathSum(TreeNode root) {
        int[] max = maxSum(root);
        return max==null?0:Math.max(max[0],max[1]);
    }
    
    private int[] maxSum(TreeNode root){
        if (root==null) return null;
        
        int[] left = maxSum(root.left);
        int[] right = maxSum(root.right);
        
        if(left!=null&&right!=null){
            int first = root.val;
            first = Math.max(first, root.val+left[0]);
            first = Math.max(first, root.val+right[0]);
            
            int second = first;
            second = Math.max(second, left[1]);
            second = Math.max(second, right[1]);
            second = Math.max(second, left[0]+root.val+right[0]);
            
            return new int[]{first,second};
        }
        else if (left!=null){
            int first = root.val;
            first = Math.max(first, root.val+left[0]);
            return new int[]{first, Math.max(first,left[1])};
        }
        else if (right!=null){
            int first = root.val;
            first = Math.max(first, root.val+right[0]);
            return new int[]{first, Math.max(first,right[1])};
        }
        else
        {
            return new int[]{root.val, root.val};
        }
    }
}
