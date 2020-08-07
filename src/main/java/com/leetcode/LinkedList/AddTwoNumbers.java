package com.leetcode.LinkedList;

import com.datastructures.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLength(l1), len2 = getLength(l2);
        ListNode p1 = l1, p2 = l2;
        
    }

    public int getLength(ListNode head) {
        if (head == null) return 0;
        ListNode p = head;
        int count = 1;
        while (p.next != null) {
            p = p.next;
            count++;
        }
        return count;
    }
}
