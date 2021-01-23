package com.leetcode3.LinkedList;

import com.datastructures.ListNode;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, curr = head;
        while (curr != null) {
            if (val == curr.val) {
                pre.next = curr.next;
                curr = curr.next;
            } else {
                curr = curr.next;
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}
