package com.leetcode.LinkedList;

import com.datastructures.ListNode;

import java.util.List;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class RemoveNthNodeFromEndOfList {

    public int getLength(ListNode head) {
         if (head == null) return 0;
         int count = 1;
         ListNode p = head;
         while (p.next != null) {
             count++;
             p = p.next;
         }
         return count;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode p = head.next;
        int counter = 1;
        int nth = getLength(head) - n + 1;
        while (counter != nth - 1) {
            p = p.next;
            pre = pre.next;
            counter++;
        }
        while (p.next != null) {
            p.val = p.next.val;
            p = p.next;
            pre = pre.next;
        }
        pre.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        RemoveNthNodeFromEndOfList so = new RemoveNthNodeFromEndOfList();
        so.removeNthFromEnd(node1, 2);
        System.out.println("hello");
    }
}
