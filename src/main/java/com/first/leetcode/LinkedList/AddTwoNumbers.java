package com.first.leetcode.LinkedList;

import com.datastructures.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLength(l1), len2 = getLength(l2);
        ListNode p1 = l1, p2 = l2;
        int loopLen = Math.max(len1, len2);
        int carry = 0;
        ListNode curr = new ListNode();
        ListNode dummy = curr;
        int val1 = 0, val2 = 0;
        for (int i = 0; i < loopLen; i++) {
            if (p1 != null) {
                val1 = p1.val;
            } else val1 = 0;
            if (p2 != null) {
                val2 = p2.val;
            } else  val2 = 0;
            //产生新节点并进行链接
            ListNode next = new ListNode(val1 + val2 + carry);
            curr.next = next;

            //设置进位
            if (val1 + val2 + carry >= 10) {
                next.val = val1 + val2 + carry - 10;
                carry = 1;
            } else carry = 0;

            if (p1 != null && p1.next != null) {
                p1 = p1.next;
            } else p1 = null;
            if (p2 != null && p2.next != null) {
                p2 = p2.next;
            } else p2 = null;

            curr = curr.next;
            
        }
        if (carry == 1) {
            curr.next = new ListNode(1);
        }
        return dummy.next;
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

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(0);
//        ListNode node4 = new ListNode(5);
//        ListNode node5 = new ListNode(6);
//        ListNode node6 = new ListNode(4);
        node1.next = node2;
//        node2.next = node3;
//        node4.next = node5;
//        node5.next = node6;
        AddTwoNumbers so = new AddTwoNumbers();
        ListNode ans = so.addTwoNumbers(node1, node3);
        System.out.println("wewe");
    }
}
