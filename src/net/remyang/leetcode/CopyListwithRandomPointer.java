package net.remyang.leetcode;

/**
 * https://oj.leetcode.com/problems/copy-list-with-random-pointer/
 * 
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 */
public class CopyListwithRandomPointer {

	public RandomListNode copyRandomList(RandomListNode head) {

		// A->B->C-><END>
		// A->AA->B->BB->C->CC-><END>
		RandomListNode now = head;
		while (now != null) {
			RandomListNode retNow = new RandomListNode(now.label);
			retNow.next = now.next;
			now.next = retNow;
			now = retNow.next;
		}

		// set the random pointers
		now = head;
		while (now != null) {
			RandomListNode retNow = now.next;
			retNow.random = now.random == null ? null : now.random.next;
			now = retNow.next;
		}

		// break the links
		now = head;
		RandomListNode retHead = null;
		if (now != null) {
			retHead = now.next;
			RandomListNode prev = retHead;

			do {
				now.next = prev.next;
				now = now.next;
				prev.next = (now == null) ? null : now.next;
				prev = prev.next;
			} while (now != null);
		}

		return retHead;
	}
}
