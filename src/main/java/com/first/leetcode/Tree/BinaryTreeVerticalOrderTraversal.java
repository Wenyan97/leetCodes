package com.first.leetcode.Tree;

import com.datastructures.TreeNode;

import java.util.*;

/**
 * @author wenyan
 */
class ResultType implements Comparable<ResultType>{
    TreeNode root;
    int mark;

    public ResultType(TreeNode root) {
        this.root = root;
    }

    public ResultType(TreeNode root, int mark) {
        this.root = root;
        this.mark = mark;
    }


    @Override
    public int compareTo(ResultType o) {
        return this.mark - o.mark;
    }
}
public class BinaryTreeVerticalOrderTraversal {
    //key:对应标记值， val:对应数组
//    Map<Integer, List<Integer>> map = new HashMap<>();
//    Map<TreeNode, Integer> map = new HashMap<>();
    List<ResultType> list = new ArrayList<>();
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        dfs(root, 0);
        Collections.sort(list);
        int p = 0, q = p;
        while (q < list.size()) {
            int tmp = list.get(p).mark;
            List<Integer> tmpArr = new ArrayList<>();
            while (list.get(q).mark == tmp) {
                tmpArr.add(list.get(q).root.val);
                q++;
                if (q >= list.size()) break;
            }
            p = q;
            ans.add(tmpArr);
        }
        return ans;
    }
    public List<Integer> dividing(List<Integer> list, int start, int end) {
        for (int i = start; i < end; i++) {
            list.add(this.list.get(start).root.val);
        }
        return list;
    }
    public void dfs(TreeNode root, int mark) {
        if (root == null) return;
        ResultType node = new ResultType(root, mark);
        list.add(node);
        if (root.left != null) {
            dfs(root.left, mark - 1);
        }
        if (root.right != null) {
            dfs(root.right, mark + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        BinaryTreeVerticalOrderTraversal so = new BinaryTreeVerticalOrderTraversal();
        List<List<Integer>> list = so.verticalOrder(node1);
        System.out.println("sdsds");
    }


    public List<List<Integer>> verticalOrder2(TreeNode root) {
        // Write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        Queue<Integer> qCol = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        qCol.offer(0);

        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            int col = qCol.poll();
            if(!map.containsKey(col)) {
                map.put(col, new ArrayList<Integer>(Arrays.asList(curr.val)));
            } else {
                map.get(col).add(curr.val);
            }
            if(curr.left != null) {
                queue.offer(curr.left);
                qCol.offer(col - 1);
            }
            if(curr.right != null) {
                queue.offer(curr.right);
                qCol.offer(col + 1);
            }
        }
        for(int n : map.keySet()) {
            results.add(map.get(n));
        }
        return results;
    }

}
