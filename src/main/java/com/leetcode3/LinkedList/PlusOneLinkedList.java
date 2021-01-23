package com.leetcode3.LinkedList;

import java.util.List;
import java.util.Stack;

import com.datastructures.ListNode;

public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        // Write your code here
        if (head == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        int carry = 1;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            curr.val += carry;
            if (curr.val >= 10) {
                carry = 1;
                curr.val -= 10;
            } else {
                carry = 0;
            }
        }
        if (dummy.val == 1) {
            return dummy;
        } else return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        PlusOneLinkedList solution = new PlusOneLinkedList();
        ListNode head = solution.plusOne(node1);
        System.out.println(123);
    }
}
