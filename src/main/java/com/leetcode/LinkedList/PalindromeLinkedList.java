package com.leetcode.LinkedList;

import com.datastructures.ListNode;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        int length = 1;
        ListNode right = head, left = head;
        while (right.next != null) {
            right = right.next;
            length++;
        }
        //构成循环链表
        right.next = head;
        for (int i = 0; i < length / 2; i++) {
            if (left.val != right.val) return false;
            left = left.next;
            for (int j = 0; j < length - 1; j++) {
                right = right.next;
            }
        }
        return true;
    }


    /**
     * recursion
     */
    ListNode ref;
    public boolean isPalindrome2(ListNode head) {
        ref = head;
        return check(head);
    }

    public boolean check(ListNode node){
        if(node == null) return true;
        boolean ans = check(node.next);
        boolean isEqual = (ref.val == node.val)? true : false;
        ref = ref.next;
        return ans && isEqual;
    }
}
