package com.leetcodes;

import java.util.*;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class Q429 {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        //插入根节点
        queue.offer(root);
        //数组插入根节点
        List<Integer> l = Arrays.asList(root.val);
        res.add(l);
        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                Node tmp = queue.poll();
                //取每个节点的孩子数量
                int nLength = tmp.children.size();
                for (int j = 0; j < nLength; j++) {
                    arr.add(tmp.children.get(j).val);
                    if (tmp.children.get(j) != null) {
                        queue.offer(tmp.children.get(j));
                    }
                }
            }
            if (arr.size() > 0) {
                res.add(arr);
            }
        }
        return res;
    }



}
