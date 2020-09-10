package com.first.leetcode.Tree;

import com.datastructures.TreeNode;

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
 *
 * 样例
 * Example1
 *
 * Input: {1,2,3,4,5}
 * Output: {4,5,2,#,#,3,1}
 * Explanation:
 * The input is
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 *
 *       1
 *      / \
 *     2——3
 *    / \
 *   4——5
 *       1
 *      /
 *     2——3
 *    /
 *   4——5
 */
public class BinaryTreeUpsideDown {
    public TreeNode ans;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // write your code here
        if (root == null) return null;
        changeBinaryTree(root, 1, getDepth(root));
        return ans;

    }
    public int getDepth(TreeNode root) {
        return root == null ? 0 : Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
    public void changeBinaryTree(TreeNode root,int currDep,  int depth) {
        if (root == null) return;
        changeBinaryTree(root.left, currDep + 1, depth);
        if (currDep == depth) {
            this.ans = root;
        }
        //中序遍历 + 回溯
        if (root.left == null && root.right == null) return;
        //分两种情况改变节点之间连接情况
        if (root.left != null) {
            if (root.right != null) {
                root.left.left = root.right;
            } else {
                root.left.left = null;
            }
            root.left.right = root;
            root.right = null;
            root.left = null;
        }
        currDep--;
        changeBinaryTree(root.right, currDep + 1, depth);
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
        BinaryTreeUpsideDown so = new BinaryTreeUpsideDown();
        System.out.println(so.getDepth(node1));
        TreeNode ans = so.upsideDownBinaryTree(node1);
        System.out.println(so.getDepth(node1));
    }
}
