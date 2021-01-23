package com.leetcode3.LinkedList;

import java.util.List;
import java.util.Stack;

import com.datastructures.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode c1 = l1, c2 = l2;
        int carry = 0;
        ListNode curr = new ListNode(0);
        ListNode dummy = curr;
        while (c1 != null || c2 != null || carry != 0){
            int val1 = c1 == null ? 0 : c1.val;
            int val2 = c2 == null ? 0 : c2.val;
            int resVal = val1 + val2 + carry;
            if (c1 != null) {
                c1 = c1.next;
            }
            if (c2 != null) {
                c2 = c2.next;
            }
            if (resVal >= 10) {
                carry = 1;
                resVal -= 10;
            } else carry = 0;
            ListNode post = new ListNode(resVal);
            curr.next = post;
            curr = post;
        }
        return dummy.next;
    }
}
