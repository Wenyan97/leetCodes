package com.leetcode3.LinkedList;

import com.datastructures.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode();
        ListNode curr = dummy;          
        while (l1 != null && l2 != null) {
           ListNode tmp = new ListNode(Math.min(l1.val, l2.val));
           curr.next = tmp;
           curr = curr.next;
           if (l1.val <= l2.val) {
               l1 = l1.next;
           } else l2 = l2.next;
        }
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }
        return dummy.next;    
    }
}
