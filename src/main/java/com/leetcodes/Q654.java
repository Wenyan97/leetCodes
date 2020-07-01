package com.leetcodes;

import java.util.Arrays;

/**
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 * 示例 ：
 *
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 * 提示：
 * 给定的数组的大小在 [1, 1000] 之间。
 */
public class Q654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return  helper(nums);
    }

    public TreeNode helper(int[] nums) {
        if (nums.length <= 0) {
            return null;
        }
        int rootVal = findMax(nums);
        TreeNode root = new TreeNode(rootVal);
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == rootVal) {
                index = i;
            }
        }
        root.left = helper(Arrays.copyOfRange(nums, 0, index));
        root.right = helper(Arrays.copyOfRange(nums, index + 1, nums.length));
        return root;
    }

    public int findMax(int[] nums) {
        int[] tmp = nums.clone();
        Arrays.sort(tmp);
        return tmp[tmp.length - 1];
    }
    //找出最大二叉树根节点
    public int findMax(int[] nums, int left, int right) {
        int[] tmp = nums.clone();
        int max = 0;
        for (int i = left; i <= right ; i++) {
            if (tmp[i] > max) {
                max = tmp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        Q654 solution = new Q654();
        TreeNode root = solution.constructMaximumBinaryTree(nums);
        System.out.println(root.left.val);
    }
}
