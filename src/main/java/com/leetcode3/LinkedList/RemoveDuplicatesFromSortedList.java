package com.leetcode3.LinkedList;

import com.datastructures.ListNode;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head, curr = head.next;
        while (curr != null) {
            if (curr.val == pre.val) {
                pre.next = curr.next;
                curr = curr.next;
            } else {
                curr = curr.next;
                pre = pre.next;
            }
        }
        return head;
    }
}
