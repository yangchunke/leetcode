package leetcode;

public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        return _sortedListToBST(head, null);
    }
    
    private TreeNode _sortedListToBST(ListNode head, ListNode tail){
        
        if (head==tail) return null;
        
        ListNode middle = getMiddle(head, tail);
        TreeNode parent = new TreeNode(middle.val);
        
        parent.left = _sortedListToBST(head, middle);
        parent.right = _sortedListToBST(middle.next, tail);
        return parent;
    }
    
    private ListNode getMiddle(ListNode head, ListNode tail){
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast!=tail){
            fast=fast.next;
            if (fast!=tail){
                slow=slow.next;
                fast=fast.next;
            }
        }
        
        return slow;
    }

}
