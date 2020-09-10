package com.first.leetcode.LinkedList;

import com.datastructures.ListNode;

public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        // Write your code here
        if (head == null) return null;
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
        }
        if (p.val <= 8) {
            p.val++;
            return head;
        } else {
            ListNode dummy = new ListNode(0);
            int length = getLength(head);
            dummy.next = head;
            //构成循环链表
            p.next = dummy;
            while (p.val == 9) {
                p.val = 0;
                for (int i = 0; i < length; i++) {
                    p = p.next;
                }
            }
            p.val++;
            //将循环链表切除
            ListNode k = head;
            for (int i = 1; i < length; i++) {
                k = k.next;
            }
            k.next = null;
            if (dummy.val == 1) {
                return dummy;
            } else return dummy.next;
        }
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
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        PlusOneLinkedList so = new PlusOneLinkedList();
        ListNode head = so.plusOne(node1);
        System.out.println("232");
    }
}
