package com.leetcode.LinkedList;

import com.datastructures.ListNode;

import java.util.List;

/**
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = reverseList(head.next);
        ListNode tmp = next;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = head;
        head.next = null;
        return next;
    }

    public ListNode reverseList2(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode nextNode=head.next;
        ListNode newHead=reverseList(nextNode);
        nextNode.next=head;
        head.next=null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ReverseLinkedList so = new ReverseLinkedList();
        so.reverseList(node1);
        System.out.println(node1.val);
    }
}
