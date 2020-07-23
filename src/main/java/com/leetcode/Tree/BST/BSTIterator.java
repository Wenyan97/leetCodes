package com.leetcode.Tree.BST;

import com.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 */
public class BSTIterator {
    public List<Integer> bstList = new ArrayList<>();
    public int index = 0;//全局指针
    public BSTIterator(TreeNode root) {
        dfs(root);
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        bstList.add(root.val);
        dfs(root.right);
    }

    /** @return the next smallest number */
    public int next() {
        int ans =  bstList.get(index);
        index++;
        return ans;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index != bstList.size();
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
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());

    }
}
