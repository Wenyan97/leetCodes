package com.first.leetcode.LinkedList;

import com.datastructures.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        ListNode pre = head, tail = head, start = head, end = head;
        int counter = 1;
        while (counter + 1 != m) {
            counter++;
            pre = pre.next;
            start = start.next;
        }
        start = pre.next;
        counter = 1;
        while (counter != n) {
            counter++;
            end = end.next;
            tail = tail.next;
        }
        tail = end.next;
        pre.next = end;
        reverseList(start, tail);
        start.next = tail;
        return head;
    }

    public ListNode reverseList(ListNode head, ListNode tail) {
        if(head == tail || head.next == tail) return head;
        ListNode newHead = reverseList(head.next, tail);
        head.next.next=head;
        head.next=null;
        return head;
    }

    public ListNode reveseBet(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for(int i = 0; i<m-1; i++) pre = pre.next;

        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5

        for(int i=0; i<n-m; i++)
        {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

        return dummy.next;
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
        ReverseLinkedListII so = new ReverseLinkedListII();
        so.reverseBetween(node1, 3, 5);
        System.out.println("232");
    }
}
