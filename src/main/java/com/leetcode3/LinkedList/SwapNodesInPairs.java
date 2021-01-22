package com.leetcode3.LinkedList;

import java.util.List;

import com.datastructures.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode first = head, second = head.next;
        while (first != null && second != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
            first = second.next;
            second = first == null ? null : first.next;
        }
        return head;
    }
}
