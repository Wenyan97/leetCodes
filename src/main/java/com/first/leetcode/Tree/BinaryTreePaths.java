package com.first.leetcode.Tree;

import com.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        for (String leftPath : leftPaths) {
            paths.add(root.val + "->" + leftPath);
        }
        for (String rightPath : rightPaths) {
            paths.add(root.val + "->" + rightPath);
        }
        if (paths.size() == 0) {
            paths.add(root.val + "");
        }
        return paths;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        BinaryTreePaths solution = new BinaryTreePaths();
        solution.binaryTreePaths(node1);
        System.out.println(222);
    }
}
