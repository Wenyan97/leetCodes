package com.leetcode.LinkedList;

import com.datastructures.ListNode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 */
public class LinkedListCycleII {
    /**
     * 第⼀次相遇时，假设慢指针 slow ⾛了 k 步，那么快指针 fast ⼀定⾛了 2k
     * 步，也就是说⽐ slow 多⾛了 k 步（也就是环的⻓度）。
     * 设相遇点距环的起点的距离为 m，那么环的起点距头结点 head 的距离为 k -
     * m，也就是说如果从 head 前进 k - m 步就能到达环起点。
     * 巧的是，如果从相遇点继续前进 k - m 步，也恰好到达环起点。
     * 双指针技巧总结
     * 95
     * 所以，只要我们把快慢指针中的任⼀个重新指向 head，然后两个指针同速
     * 前进，k - m 步后就会相遇，相遇之处就是环的起点了。
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
