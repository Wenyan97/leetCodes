//Given a binary tree and a sum, find all root-to-leaf paths where each path's s
//um equals the given sum. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// Given the below binary tree and sum = 22, 
//
// 
//      5
//     / \
//    4   8
//   /   / \
//  11  13  4
// /  \    / \
//7    2  5   1
// 
//
// Return: 
//
// 
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics Tree Depth-first Search 
// 👍 2048 👎 73

package com.second.leetcode.editor.en;

import com.datastructures.TreeNode;

import java.util.*;

public class PathSumIi {
    public static void main(String[] args) {
        Solution solution = new PathSumIi().new Solution();
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, sum, new ArrayList<>());
        return res;
    }

    public void helper(TreeNode root, int sum, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                res.add(new ArrayList<>(list));
            }
        }
        helper(root.left, sum - root.val, list);
        helper(root.right, sum - root.val, list);
        //recursion
        list.remove(list.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
