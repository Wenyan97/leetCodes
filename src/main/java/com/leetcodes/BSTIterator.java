package com.leetcodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTIterator {

    static List<Integer> arrBST = new ArrayList<>();
    static int index = 0;
    static boolean hasNext = false;

    public BSTIterator(TreeNode root) {
        if (root != null) {
            new BSTIterator(root.left);
            arrBST.add(root.val);
            new BSTIterator(root.right);
        }
    }

    /** @return the next smallest number */
    public int next() {
        int res = arrBST.get(index);
        index++;
        int hasNextIndex = index;
        if (hasNextIndex >= arrBST.size()) {
            this.hasNext = false;
        } else {
            this.hasNext = true;
        }
        return res;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
       return this.hasNext;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(20);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        BSTIterator iterator = new BSTIterator(node1);
        System.out.println(iterator.next());   // 返回 3
        System.out.println(iterator.next());    // 返回 7
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next());   // 返回 9
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next());    // 返回 15
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next());    // 返回 20
        System.out.println(iterator.hasNext()); // 返回 false
    }
}
