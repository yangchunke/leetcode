package leetcode;

public class PopulatingNextRightPointers {
    public void connect(TreeLinkNode root) {
        
        if (root==null) return;
        
        TreeLinkNode currHead = root;
        TreeLinkNode newHead = null;
        TreeLinkNode newTail = null;
        
        while(currHead.left!=null){
            
            if (newHead==null){
                newHead = currHead.left;
            }
            else
            {
                newTail.next = currHead.left;
            }
            
            currHead.left.next = currHead.right;
            newTail = currHead.right;
            currHead = currHead.next;
            
            if (currHead==null){
                currHead = newHead;
                newHead = null;
                newTail = null;
            }
        }
    }

}
