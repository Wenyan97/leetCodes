package com.leetcode.LinkedList;

import com.datastructures.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head;
        List<Integer> list = new ArrayList<>();
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        Collections.sort(list);
        ListNode newHead = new ListNode();
        p = newHead;
        for (Integer integer : list) {
            ListNode tmp = new ListNode(integer);
            p.next = tmp;
            p = p.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        SortList so = new SortList();
        ListNode newHEAD = so.sortList(node1);
        System.out.println(1212);
    }
}
