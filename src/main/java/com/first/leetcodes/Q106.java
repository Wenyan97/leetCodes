package com.first.leetcodes;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class Q106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(postorder, inorder, 0, n - 1, 0, n - 1, indexMap);
    }

    public TreeNode myBuildTree(int[] postorder, int[] inorder,
                                int postorder_left, int postorder_right,
                                int inorder_left, int inorder_right, Map<Integer, Integer> indexMap) {
        if (postorder_left > postorder_right) {
            return null;
        }

        int inorder_root = indexMap.get(postorder[postorder_right]);

        TreeNode root = new TreeNode(postorder[postorder_right]);

        int size_left_subtree = inorder_root - inorder_left;

        root.left = myBuildTree(postorder, inorder, postorder_left, postorder_left + size_left_subtree - 1, inorder_left, inorder_root - 1, indexMap);

        root.right = myBuildTree(postorder, inorder, postorder_left + size_left_subtree, postorder_right - 1, inorder_root + 1, inorder_right, indexMap);

        return root;
    }
}
