//Given a binary tree, return all root-to-leaf paths. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// 
//Input:
//
//   1
// /   \
//2     3
// \
//  5
//
//Output: ["1->2->5", "1->3"]
//
//Explanation: All root-to-leaf paths are: 1->2->5, 1->3
// Related Topics Tree Depth-first Search 
// 👍 1929 👎 112

package com.second.leetcode.editor.en;

import com.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        List<String> res = solution.binaryTreePaths(node1);
        System.out.println("hello");

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
    List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) return res;
        recursion(root, new StringBuilder(""));
        return res;
    }

    public void recursion(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        //用来记录数字长度，用于回溯时候删除
        int len = String.valueOf(root.val).length();
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            res.add(sb.toString());
            sb.delete(sb.length() - len, sb.length());
            return;
        }
        sb.append(root.val).append("->");
        recursion(root.left, sb);
        recursion(root.right, sb);
        sb.delete(sb.length() - len - 2, sb.length());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
