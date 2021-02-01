package com.leetcode3.DynamicProgramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String str:wordDict){
            set.add(str);
        }
        //前n个字符能否拆分 s = "leetcode", wordDict = ["leet", "code"]
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1; i<=s.length(); i++){
            for(int j=i; j>=0; j--){
                dp[i] = dp[j] && set.contains(s.substring(j,i));
                if(dp[i]) break; 
            }
        }
        return dp[s.length()];
    }
}
