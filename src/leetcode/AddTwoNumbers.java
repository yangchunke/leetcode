/**
 * Add Two Numbers 
 */
package leetcode;

/**
 * http://leetcode.com/onlinejudge#question_2
 * 
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 */

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode head = null;
		ListNode nn = null;

		int carry = 0;
		while (l1 != null || l2 != null) {
			int sum = (l1==null?0:l1.val) + (l2==null?0:l2.val) + carry;
			int val = sum;
			if (sum > 9) {
				carry = 1;
				val = sum - 10;
			} else {
				carry = 0;
			}

			if (head == null) {
				head = new ListNode(val);
				nn = head;
			} else {
				nn.next = new ListNode(val);
				nn = nn.next;
			}

			l1 = l1.next;
			l2 = l2.next;
		}

		if (carry == 1) {
			nn.next = new ListNode(1);
		}

		return head;
	}
}
