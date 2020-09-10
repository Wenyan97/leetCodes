package com.first.leetcode.Tree.BST;

import com.datastructures.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 */
public class ClosestBinarySearchTreeValue {
    double ans;
    Map<Double, TreeNode> subMap;
    public int closestValue(TreeNode root, double target) {
        // write your code here
        subMap = new HashMap<>();
        this.ans = Math.abs(Double.MAX_VALUE - target);
        helper(root, target);
        return subMap.get(ans).val;
    }

    public void helper(TreeNode root, double target) {
        if (root == null) return;
        double subValue = Math.abs(root.val - target);
        //把每个节点对应的差值存入map
        subMap.put(subValue, root);
        ans = Math.min(ans, subValue);
        helper(root.left, target);
        helper(root.right, target);
    }

}
