package com.first.leetcode.LinkedList;

import com.datastructures.ListNode;

public class RotateList {
    //timeout
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        if (k == 0) return head;
        ListNode curr = head.next;
        ListNode pre = head;
        int len = 2;
        while (curr.next != null) {
            curr = curr.next;
            pre = pre.next;
            len++;
        }
        curr.next = head;
        for (int i = 0; i < k - 1; i++) {
            curr = pre;
            for (int j = 0; j < len - 1; j++) {
                pre = pre.next;
            }
        }
        pre.next = null;
        return curr;
    }

    public ListNode rotateRight2(ListNode head, int k) {
        if(head == null)
            return null;
        int size = 1; // since we are already at head node
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null){
            size++;
            fast = fast.next;
        }

        for(int i = size - k % size; i > 1; i--) // i>1 because we need to put slow.next at the start.
            slow = slow.next;

        // No dummy variable.
        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        RotateList so = new RotateList();
        ListNode head = so.rotateRight2(node1, 5);
        System.out.println(2);
    }
}
