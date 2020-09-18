package com.second.leetcode.editor.en;

import com.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.
 *
 * Example
 * Example1
 * Input: {1,2,3,4,5}
 * Output: [[4, 5, 3], [2], [1]].
 * Explanation:
 *
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * Example2
 * Input: {1,2,3,4}
 * Output: [[4, 3], [2], [1]].
 * Explanation:
 *
 *     1
 *    / \
 *   2   3
 *  /
 * 4
 */
public class FindLeavesOfBinaryTree {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> leavesList = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        // write your code here
        if (root == null) return list;
        while (root.left != null || root.right != null) {
            dfs(root);
            list.add(new ArrayList<>(leavesList));
            leavesList.clear();
        }
        leavesList.add(root.val);
        list.add(leavesList);
        return list;
    }

    public TreeNode dfs(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            leavesList.add(root.val);
            return null;
        }
        root.left = dfs(root.left);
        root.right = dfs(root.right);
        return root;
    }


    public static void main(String[] args) {
        FindLeavesOfBinaryTree solution = new FindLeavesOfBinaryTree();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        List<List<Integer>> list = solution.findLeaves(node1);
        System.out.println("hello");
    }
}
