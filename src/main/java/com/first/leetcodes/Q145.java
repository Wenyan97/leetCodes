package com.first.leetcodes;

import java.util.ArrayList;
import java.util.List;

public class Q145 {
    List<Integer> postorderList = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            postorderList.add(root.val);
        }
        return postorderList;
    }
}
