package com.first.leetcode.Tree;

import com.datastructures.TreeNode;
import java.util.*;

/**
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.
 *
 * 样例
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
 */
public class FindLeavesOfBinaryTree {
    List<List<Integer>> ans =  new ArrayList<>();
    Set<TreeNode> set = new HashSet<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        // write your code here
        if (root == null) return ans;
        dfsSet(root);
        while (!set.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            helper(root, tmp);
            ans.add(tmp);
        }
        return ans;
    }

    public void dfsSet(TreeNode root) {
        if (root != null) {
            set.add(root);
            dfsSet(root.left);
            dfsSet(root.right);
        }
    }
    public TreeNode helper(TreeNode root, List<Integer> tmp) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            tmp.add(root.val);
            set.remove(root);
            return null;
        }
        root.left = helper(root.left, tmp);
        root.right = helper(root.right, tmp);
        return root;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        FindLeavesOfBinaryTree solution = new FindLeavesOfBinaryTree();
        solution.findLeaves(node1);
        System.out.println("success");
    }
}
