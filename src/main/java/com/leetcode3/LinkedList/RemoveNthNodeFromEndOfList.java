package com.leetcode3.LinkedList;

import java.util.List;

import com.datastructures.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        int m = getLength(head) + 1 - n; // 正数要删除的节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        ListNode curr = pre.next;
        pre.next = curr.next;
        return dummy.next;
    }

    public int getLength(ListNode head) {
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }
}
