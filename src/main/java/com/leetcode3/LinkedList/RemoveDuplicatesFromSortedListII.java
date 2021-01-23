package com.leetcode3.LinkedList;

import com.datastructures.ListNode;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, curr = head, post = head.next;
        while (post != null) {
            if (curr.val == post.val) {
                int tmp = curr.val;
                while (post != null && post.val == tmp) {
                    curr.next = post.next;
                    post = curr.next;
                }
                pre.next = post;
                curr = post;
                post = post == null ? null : post.next;
            } else {
                post = post.next;
                curr = curr.next;
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}
