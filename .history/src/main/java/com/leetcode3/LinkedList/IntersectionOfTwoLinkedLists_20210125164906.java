package com.leetcode3.LinkedList;

import com.datastructures.ListNode;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr1 = headA, curr2 = headB;
        while (curr1 != curr2) {
            curr1 = curr1 == null ? headB : curr1.next;
            curr2 = curr2 == null ? headA : curr2.next;
        }
        return curr1;
    }
}
