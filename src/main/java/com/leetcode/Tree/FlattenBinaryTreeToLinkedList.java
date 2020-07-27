package com.leetcode.Tree;

import com.datastructures.TreeNode;

import java.util.*;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
//        Map<TreeNode, TreeNode> map = new HashMap<>(); //当前节点， 前驱节点
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).right = list.get(i + 1);
            list.get(i).left = null;
        }
    }

    public void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        list.add(root);
        dfs(root.left, list);
        dfs(root.right, list);
    }
}
