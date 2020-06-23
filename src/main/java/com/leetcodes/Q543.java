package com.leetcodes;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * 示例 :
 * 给定二叉树
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 */
public class Q543 {
    int res = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root != null) {
            res = Math.max(res, getOnePath(root));
            dfs(root.left);
            dfs(root.right);
        }
    }

    //获取从某一根的路径
    public int getOnePath(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;
        return getDepth(root.right) + getDepth(root.left);
    }

    public int getDepth(TreeNode root) {
        return root == null ? 0 : Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        node1.right = node2;
        node2.left = node3;
        Q543 solution = new Q543();
        System.out.println(solution.getOnePath(node1));
    }
}
