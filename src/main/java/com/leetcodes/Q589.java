package com.leetcodes;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 */
public class Q589 {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root != null) {
            ans.add(root.val);
            for (int i = 0; i < root.children.size(); i++) {
                preorder(root.children.get(i));
            }
        }
        return ans;
    }
}
