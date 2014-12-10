package net.remyang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/lru-cache/
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * 
 * set(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 */
public class LRUCache {

	private class Item {
		int key;
		int val;
		Item next;
		Item prev;

		Item(int k, int v) {
			key = k;
			val = v;
		}
	}

	private int capacity;
	private int numOfItems;
	private Item head;
	private Item tail;
	private Map<Integer, Item> items;

	public LRUCache(int c) {
		capacity = c;
		items = new HashMap<Integer, Item>();
	}

	public int get(int key) {
		Item item = items.get(key);
		if (item == null) {
			return -1;
		}
		moveToHead(item);
		return item.val;
	}

	public void set(int key, int val) {
		Item item = items.get(key);
		if (item == null) {
			enQueue(new Item(key, val));
		} else {
			item.val = val;
			moveToHead(item);
		}
	}

	private void connect(Item first, Item second) {
		first.next = second;
		second.prev = first;
	}

	private void enQueue(Item item) {
		if (numOfItems == capacity) {
			deQueue();
		}
		if (head == null) {
			head = tail = item;
			connect(head, tail);
		} else {
			connect(item, head);
			connect(tail, item);
			head = item;
		}
		items.put(item.key, item);
		numOfItems++;
	}

	private void deQueue() {
		Item ret = tail;
		if (head == tail) {
			head = null;
			tail = null;
		} else {
			tail = tail.prev;
			connect(tail, head);
		}
		if (ret != null) {
			items.remove(ret.key);
			numOfItems--;
		}
	}

	private void moveToHead(Item item) {
		if (item == head) {
			// no-op
		} else if (item == tail) {
			head = tail;
			tail = tail.prev;
		} else {
			connect(item.prev, item.next);
			connect(item, head);
			connect(tail, item);
			head = item;
		}
	}
}
