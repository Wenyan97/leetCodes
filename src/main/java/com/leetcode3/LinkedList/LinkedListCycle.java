package com.leetcode3.LinkedList;

import com.datastructures.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, quick = head;
        while (slow != null && quick != null) {
            slow = slow.next;
            quick = quick.next;
            if (quick != null) quick = quick.next;
            if (slow == quick) {
                return true;
            }
        }
        return false;
    }
}
