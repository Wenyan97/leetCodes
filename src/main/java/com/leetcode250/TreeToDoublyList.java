package com.leetcode250;



// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

public class TreeToDoublyList {
    Node head = null;
    Node pre = null;
    public Node treeToDoublyList(Node root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void dfs(Node root) {
        if (root == null) return;
        dfs(root.left);
        if (pre == null) {
            head = root;
        } else {
            pre.right = root;
            root.left = pre;
        }
        pre = root;
        dfs(root.right);
    }   
}
