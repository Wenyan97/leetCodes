package com.leetcode.Tree;

import com.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * Note: A leaf is a node with no children.
 */
public class SumRootToLeafNumbers {
    List<Integer> numberList = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        int total = 0;
        for (Integer integer : numberList) {
            total += integer;
        }
        return total;
    }

    public void dfs(TreeNode root, int sum) {
        if (root == null) return;
        sum += root.val;
        if (root.left == null && root.right == null) {
            numberList.add(sum);
        }
        dfs(root.left, sum * 10);
        dfs(root.right, sum * 10);
    }



    int sum = 0;
    public int sumNumbers2(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return sum;
    }

    public void dfs2(TreeNode root, int currSum) {
        if (root == null) return;
        currSum += root.val;
        if (root.left == null && root.right == null) {
            sum += currSum;
            return;
        }
        dfs(root.left, currSum * 10);
        dfs(root.right, currSum * 10);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        SumRootToLeafNumbers solution = new SumRootToLeafNumbers();
        solution.dfs(node1, 0);
        System.out.println("sdsd");
    }
}
