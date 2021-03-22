package com.leetcode3.backtracking2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1：

输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]
示例 2：

输入：candidates = [2,3,5], target = 8,
所求解集为：
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum {
    public CombinationSum(int a) {
        System.out.println("23232");
    }

    public CombinationSum() {
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target == 0) {
            return res;
        }
        backtrack(candidates, target, new ArrayList<>(), 0, 0);
        return res;
    }

    public void backtrack(int[] candidates, int target, List<Integer> path, int sum, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtrack(candidates, target, path, sum + candidates[i], i);
            path.remove(path.size() - 1);
        }
    }


    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> min_stack;
        public MinStack() {
            stack = new Stack<>();
            min_stack = new Stack<>();
        }
        public void push(int x) {
            stack.push(x);
            if(min_stack.isEmpty() || x <= min_stack.peek())
                min_stack.push(x);
        }
        public void pop() {
            if(stack.pop().equals(min_stack.peek()))
                min_stack.pop();
        }
        public int top() {
            return stack.peek();
        }
        public int getMin() {
            return min_stack.peek();
        }
    }


    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] >= nums[i]) {
                    continue;
                }
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
    
    
 

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};

        StringBuilder s = new StringBuilder("23");
        CombinationSum solution = new CombinationSum();
        solution.combinationSum(candidates, 8);
        Map<Integer, Integer> map = new HashMap<>();
        
    }

}
