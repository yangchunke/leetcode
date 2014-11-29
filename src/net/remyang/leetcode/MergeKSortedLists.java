package net.remyang.leetcode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://oj.leetcode.com/problems/merge-k-sorted-lists/
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 */
public class MergeKSortedLists {

	public ListNode mergeKLists(List<ListNode> lists) {

		if (lists == null || lists.size() <= 0)
			return null;

		PriorityQueue<ListNode> heads = new PriorityQueue<ListNode>(
				lists.size(), new Comparator<ListNode>() {
					@Override
					public int compare(ListNode o1, ListNode o2) {
						return o1.val - o2.val;
					}
				});

		for (ListNode h : lists) {
			if (h != null) {
				heads.add(h);
			}
		}

		ListNode dummy = new ListNode(-1);
		ListNode hh = dummy;
		ListNode h = heads.poll();
		while (h != null) {
			hh.next = h;
			hh = hh.next;
			if (h.next != null) {
				heads.add(h.next);
			}
			h = heads.poll();
		}

		return dummy.next;

	}
}