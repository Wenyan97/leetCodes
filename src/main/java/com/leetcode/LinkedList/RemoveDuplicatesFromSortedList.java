package com.leetcode.LinkedList;

import com.datastructures.ListNode;

import java.util.List;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode cur = head;
        while (cur != null){
            while (cur.next != null && cur.val == cur.next.val) cur.next = cur.next.next;
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
//        ListNode node4 = new ListNode(3);
//        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        RemoveDuplicatesFromSortedList so = new RemoveDuplicatesFromSortedList();
        ListNode p = so.deleteDuplicates(node1);
        System.out.println("er");
    }
}
