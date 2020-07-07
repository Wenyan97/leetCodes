package com.leetcodes;

import java.util.ArrayList;
import java.util.List;

/**
 * 我们可以为二叉树 T 定义一个翻转操作，如下所示：选择任意节点，然后交换它的左子树和右子树。
 *
 * 只要经过一定次数的翻转操作后，能使 X 等于 Y，我们就称二叉树 X 翻转等价于二叉树 Y。
 *
 * 编写一个判断两个二叉树是否是翻转等价的函数。这些树由根节点 root1 和 root2 给出。
 */
public class Q951 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null)
                return true;
            if (root1 == null || root2 == null || root1.val != root2.val)
                return false;

            return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                    flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));

    }

    /*public boolean isRevert(TreeNode node1, TreeNode node2) {
        Integer val1L = node1.left == null ? null : node1.left.val;
        Integer val1R = node1.right == null? null :node1.right.val;
        Integer val2L = node2.left == null ? null : node2.left.val;
        Integer val2R = node2.right == null ? null : node2.right.val;
        if (val1L.equals(val2R) && val1R.equals(val2L)) {
            return true;
        }
        return false;
    }*/

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        TreeNode node11 = new TreeNode(1);
        TreeNode node22 = new TreeNode(3);
        TreeNode node33 = new TreeNode(2);
        TreeNode node44 = new TreeNode(6);
        TreeNode node55 = new TreeNode(4);
        TreeNode node66 = new TreeNode(5);
        TreeNode node77 = new TreeNode(8);
        TreeNode node88 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node5.left = node7;
        node5.right = node8;

        node11.left = node22;
        node11.right = node33;
        node22.right = node44;
        node33.left = node55;
        node33.right = node66;
        node66.left = node77;
        node66.right= node88;

        Q951 solution = new Q951();
        System.out.println(solution.flipEquiv(node1, node11));

    }
}
