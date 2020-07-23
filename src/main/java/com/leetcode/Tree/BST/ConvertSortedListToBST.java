package com.leetcode.Tree.BST;

import com.datastructures.ListNode;
import com.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


public class ConvertSortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = linkedListToArray(head);
        return sortedArrayToBST(list, 0, list.size() - 1);
    }

    public List<Integer> linkedListToArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        if (head == null) return list;
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }

    public TreeNode sortedArrayToBST(List<Integer> nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int index = (start + end) / 2;
        TreeNode root = new TreeNode(nums.get(index));
        root.left = sortedArrayToBST(nums, start, index - 1);
        root.right = sortedArrayToBST(nums, index + 1, end);
        return root;
    }


    /* ----------------------------------------------*/
    public TreeNode sortedListToBST2(ListNode head) {
        int length = findSize(head);
        return convertToBST(head, 0, length - 1);
    }

    public int findSize(ListNode head) {
        ListNode ptr = head;
        int c = 0;
        while (ptr != null) {
            ptr = ptr.next;
            c += 1;
        }
        return c;
    }

    public TreeNode convertToBST(ListNode head, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode left = convertToBST(head, start, mid - 1);
        TreeNode node = new TreeNode(head.val);
        node.left = left;
        head = head.next;
        node.right = convertToBST(head, mid + 1, end);
        return node;
    }
    /*public TreeNode creatTreeSpace(int start, int end) {
        if (start > end) {
            return null;
        }
        int index = (start + end) / 2;
        TreeNode root = new TreeNode();
        root.left = creatTreeSpace(start, index - 1);
        root.right = creatTreeSpace(index + 1, end);
        return root;
    }

    public void creatTreeMapList(TreeNode root, ListNode head) {
        if (root != null) {
            creatTreeMapList(root.left, head);
            root.val = head.val;
            head = head.next;
            creatTreeMapList(root.right, head);
        }
    }*/

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ConvertSortedListToBST so = new ConvertSortedListToBST();
        TreeNode root = so.sortedListToBST2(node1);
        System.out.println("wewe");

    }

}
