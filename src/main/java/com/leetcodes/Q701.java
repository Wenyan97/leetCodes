package com.leetcodes;

public class Q701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        insert(root, val);
        return root;
    }

    public void insert(TreeNode root, int val) {
        if (root.left == null && val < root.val) {
            root.left = new TreeNode(val);
            return;
        }
        if (root.right == null && val > root.val) {
            root.right = new TreeNode(val);
            return;
        }
        if (val > root.val) {
            insert(root.right, val);
        } else insert(root.left, val);
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(12);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        Q701 solution = new Q701();
        solution.insert(node1, 6);
        System.out.println(node3.left.val);

    }
}
