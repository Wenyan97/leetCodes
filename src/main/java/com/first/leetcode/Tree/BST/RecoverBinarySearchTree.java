package com.first.leetcode.Tree.BST;

import com.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 */
public class RecoverBinarySearchTree {
    public int firstErrNode;
    public int secondErrNode;
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        bstToArr(root, list);
        findErrNumber(list);
        exchangeNode(root, firstErrNode, secondErrNode);
    }

    //交换错误的两个节点
    public void exchangeNode(TreeNode root, int num1, int num2) {
        if (root == null) return;
        if (root.val == num1) {
            root.val = num2;
        } else if (root.val == num2) {
            root.val = num1;
        }
        exchangeNode(root.left, num1, num2);
        exchangeNode(root.right, num1, num2);
    }


    public void bstToArr(TreeNode root, List<Integer> list) {
        if (root == null) return;
        bstToArr(root.left, list);
        list.add(root.val);
        bstToArr(root.right, list);
    }

    //找出两个需要交换的number
    public void findErrNumber(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                firstErrNode = list.get(i);
                break;
            }
        }
        for (int i = list.size() - 1; i > 0 ; i--) {
            if (list.get(i) < list.get(i - 1)) {
                secondErrNode = list.get(i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
//        node3.left = node4;
        RecoverBinarySearchTree so = new RecoverBinarySearchTree();
        so.recoverTree(node1);
        System.out.println("1212121");
    }
}
