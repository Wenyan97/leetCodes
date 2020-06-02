package com.leetcodes;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * @author PC_YWY
 */
public class Q98 {
    static List<Integer> postOrderList = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) return true;
        postOrderList(root);
        int i = 0;
        while (i <= postOrderList.size() - 2) {
            if (postOrderList.get(i) > postOrderList.get(i+1)) {
                return false;
            }
            i++;
        }
        return true;
    }

    public void postOrderList(TreeNode root) {
        if (root != null) {
            postOrderList(root.left);
            postOrderList.add(root.val);
            postOrderList(root.right);
        }
       /* if (root.left != null) {
        }
        if (root.right != null) {
        }*/

    }

    public static void main(String[] args) {
        Q98 solution = new Q98();
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
//        solution.postOrderList(node1);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(-1);
//        TreeNode node8 = new TreeNode(3);
        node6.left = node7;
//        node6.right = node8;
//        solution.postOrderList(node6);
        System.out.println(solution.isValidBST(node6));
    }
}
