package com.first.leetcode.Tree;

import com.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root != null) {
            dfs(root, sum);
        }
        return ans;
    }

    public void dfs(TreeNode root, int sum) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null ) {
            if (sum == root.val) {
                ans.add(new ArrayList(list));
            } else {
                list.remove(list.size() - 1);
                return;
            }
        }
        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
        list.remove(list.size() - 1);
    }
    public void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path){
        if(root==null) return;
        path.add(root.val);

        if(root.left==null && root.right==null ){
            if(root.val==sum)
                res.add(new ArrayList<Integer>(path));
            return;
        }
        if(root.left!=null) {
            dfs(root.left,sum-root.val,res,path);
            path.remove(path.size()-1);
        }
        if(root.right!=null) {
            dfs(root.right,sum-root.val,res,path);
            path.remove(path.size()-1);
        }

    }
}
