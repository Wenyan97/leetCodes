package com.leetcode3.LinkedList;

import com.datastructures.ListNode;

public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        if (node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        } else node = null;
    }
}
