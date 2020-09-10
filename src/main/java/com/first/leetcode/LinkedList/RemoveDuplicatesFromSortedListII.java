package com.first.leetcode.LinkedList;

import com.datastructures.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * Return the linked list sorted as well.
 *
 * Example 1:
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
public class RemoveDuplicatesFromSortedListII {
    //迭代添加头节点
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
//        ListNode pre = head, curr = head.next;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            //判断节点next和next.next是否相同
            if (curr.next.val == curr.next.next.val) {
                int target = curr.next.val;
                //判断该节点是否需要删除
                while (curr.next != null && curr.next.val == target) {
                    curr.next = curr.next.next;
                }
            } else curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        /*ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);*/
        node1.next = node2;
        /*node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;*/
        RemoveDuplicatesFromSortedListII so = new RemoveDuplicatesFromSortedListII();
        so.deleteDuplicates(node1);
        System.out.println(1212);
    }
}
