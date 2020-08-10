package com.leetcode.LinkedList;

import com.datastructures.ListNode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode p = head, q = head, tmp = head;
        int len = 1;
        while (q.next != null) {
            q = q.next;
            len++;
        }
        int loopLen = len - 2;
        for (int i = 0; i < len / 2; i++) {
            q.next = p.next;
            p.next = q;
            p = q.next;
            for (int j = 0; j < loopLen; j++) {
                q = q.next;
            }
            loopLen -= 2;
        }
        p.next = null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
//        ListNode node8 = new ListNode(8);
//        ListNode node9 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
//        node7.next = node8;
//        node8.next = node9;
        ReorderList so = new ReorderList();
        so.reorderList(node1);
        System.out.println(12);
    }
}
