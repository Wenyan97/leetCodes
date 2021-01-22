package com.leetcode3.LinkedList;

import java.util.List;

import com.datastructures.ListNode;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head; // 初始化为奇数开始
        ListNode oddDummy = new ListNode();
        ListNode oddCurr = oddDummy;
        ListNode evenDummy = new ListNode();
        ListNode evenCurr = evenDummy;
        int flag = 1;
        while (curr != null) {
            if (flag == 1) {
                oddCurr.next = curr;
                oddCurr = oddCurr.next;
                flag = 0;
            } else {
                evenCurr.next = curr;
                evenCurr = evenCurr.next;
                flag = 1;
            }
            curr = curr.next;
        }
        oddCurr.next = evenDummy.next;
        evenCurr.next = null;
        return oddDummy.next;
    }
}
