package com.leetcode.LinkedList;

import com.datastructures.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        head.next = removeElements(head.next, val);
        if (head.val == val) return head.next;
        return head;
       /* ListNode pre = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.val == val) {
                pre.next = curr.next;
                pre = pre.next;
                curr = pre.next;
            } else {
                curr = curr.next;
                pre = pre.next;
            }
        }
        return head;*/
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        RemoveLinkedListElements so = new RemoveLinkedListElements();
        so.removeElements(node1, 6);
        System.out.println("hello");
    }
}
