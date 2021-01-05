package com.leetcode3.Tree.BST;

import java.util.ArrayList;
import java.util.List;

import com.datastructures.TreeNode;

/**
 *  1
   / \
  2   5
 / \   \
3   4   6

//将 1 的左子树插入到右子树的地方
    1
     \
      2         5
     / \         \
    3   4         6        
//将原来的右子树接到左子树的最右边节点
    1
     \
      2          
     / \          
    3   4  
         \
          5
           \
            6
            
 //将 2 的左子树插入到右子树的地方
    1
     \
      2          
       \          
        3       4  
                 \
                  5
                   \
                    6   
        
 //将原来的右子树接到左子树的最右边节点
    1
     \
      2          
       \          
        3      
         \
          4  
           \
            5
             \
              6         
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                curr = curr.right;
            } else {
                TreeNode pre = curr.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
                curr = curr.right;
            }
        }
    }

    // public void flatten(TreeNode root) {
    //     List<TreeNode> list = new ArrayList<>();
    //     dfs(root, list);
    //     for (int i = 0; i < list.size() - 1; i++) {
    //         list.get(i).left = null;
    //         list.get(i).right = list.get(i + 1);
    //     }
    // }


    // public void dfs(TreeNode root, List<TreeNode> list) {
    //     if (root == null) return;
    //     list.add(root);
    //     dfs(root.left, list);
    //     dfs(root.right, list);
    // }
}
