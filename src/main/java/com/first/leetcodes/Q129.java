package com.first.leetcodes;

import java.util.ArrayList;
import java.util.List;

public class Q129 {
    List<List<Integer>> allPathList = new ArrayList<>();
    List<Integer> onePathList = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        int[] numList = new int[allPathList.size()];
        for (int i = 0; i < allPathList.size(); i++) {
            numList[i] = arrToNum(allPathList.get(i));
        }
        int sum = 0;
        for (int value : numList) {
            sum += value;
        }
        return sum;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        onePathList.add(root.val);
        if (root.left == null && root.right == null) {
            allPathList.add(new ArrayList<>(onePathList));
        }
        dfs(root.left);
        dfs(root.right);
        onePathList.remove(onePathList.size() - 1);
    }

    public int arrToNum(List<Integer> list) {
        if (list == null) return 0;
        int index = 1;
        int num = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            num += list.get(i) * index;
            index *= 10;
        }
        return num;
    }

    public static void main(String[] args) {
      /*  List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(3);
        list.add(1);*/
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        Q129 solution = new Q129();
        System.out.println(solution.sumNumbers(node1));

    }

}
