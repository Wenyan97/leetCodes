package com.leetcode.Tree;

import com.datastructures.TreeNode;

/**
 * Given a binary tree, count the number of uni-value subtrees.
 *
 * A Uni-value subtree means all nodes of the subtree have the same value.
 */
public class CountUnivalueSubtrees {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        isUnivalSubtree(root);
        return count;
    }

    public boolean isUnivalSubtree(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) {
            count++;
            return true;
        }
        boolean isLeftUnivalSubtree = isUnivalSubtree(root.left);
        boolean isRightUnivalSubtree = isUnivalSubtree(root.right);
        if (root.left == null) {
            if (isRightUnivalSubtree && (root.val == root.right.val)) {
                count++;
                return true;
            }
        }
        if (root.right == null) {
            if (isLeftUnivalSubtree && (root.val == root.left.val)) {
                count++;
                return true;
            }
        }
        if (root.left != null && root.right != null) {
            if (isRightUnivalSubtree
                    && isLeftUnivalSubtree
                    && (root.val == root.left.val && root.val == root.right.val)) {
                count++;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4= new TreeNode(4);
        TreeNode node5= new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        CountUnivalueSubtrees solution = new CountUnivalueSubtrees();
        System.out.println(solution.countUnivalSubtrees(node1));
    }
}
