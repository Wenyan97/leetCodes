package com.leetcodes;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  3,2,4,1,4,2,3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * @author PC_YWY
 */
public class Q101 {
    public boolean isSymmetric(TreeNode root) {
        TreeNode reverseRoot = reverse(root);
        return isSame(root, reverseRoot);
    }

    public TreeNode reverse(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.right == null && root.left == null) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            reverse(root.left);
        }
        if (root.right != null) {
            reverse(root.right);
        }
        return root;
    }
    public boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        //只有一棵树是空树，则必不是相同的树
        if (p == null || q == null) {
            return false;
        }
        //其他情况，左子树相同，右子树相同，结点的值相同
        return p.val == q.val && isSame(p.left, q.left) && isSame(p.right, q.right);
    }

    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.val);
            inOrder(root.right);
        }
    }
   /* public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }*/

    public static void main(String[] args) {
        Q101 solution = new Q101();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
       /* node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;*/

        node2.right = node4;
        node3.right = node5;

        System.out.println(solution.isSymmetric(node1));
    }
}
