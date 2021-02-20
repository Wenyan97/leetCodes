package com.leetcode3.DP;

/**
 * 我看到“方法一”三个字的时候，惊喜地以为还有方法二。。没有，这次真没有。动态规划是个好东西，但难就难在如何定义DP数组里值的含义。听我来给你捋一捋。

啥叫编辑距离？我们说word1和word2的编辑距离为X，意味着word1经过X步，变成了word2，咋变的你不用管，反正知道就需要X步，并且这是个最少的步数。

我们有word1和word2，我们定义dp[i][j]的含义为：word1的前i个字符和word2的前j个字符的编辑距离。意思就是word1的前i个字符，变成word2的前j个字符，最少需要这么多步。

例如word1 = "horse", word2 = "ros"，那么dp[3][2]=X就表示"hor"和“ro”的编辑距离，即把"hor"变成“ro”最少需要X步。

如果下标为零则表示空串，比如：dp[0][2]就表示空串""和“ro”的编辑距离

定理一：如果其中一个字符串是空串，那么编辑距离是另一个字符串的长度。比如空串“”和“ro”的编辑距离是2（做两次“插入”操作）。再比如"hor"和空串“”的编辑距离是3（做三次“删除”操作）。

定理二：当i>0,j>0时（即两个串都不空时）dp[i][j]=min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+int(word1[i]!=word2[j]))。

啥意思呢？举个例子，word1 = "abcde", word2 = "fgh",我们现在算这俩字符串的编辑距离，就是找从word1，最少多少步，能变成word2？那就有三种方式：

知道"abcd"变成"fgh"多少步（假设X步），那么从"abcde"到"fgh"就是"abcde"->"abcd"->"fgh"。（一次删除，加X步，总共X+1步）
知道"abcde"变成“fg”多少步（假设Y步），那么从"abcde"到"fgh"就是"abcde"->"fg"->"fgh"。（先Y步，再一次添加，加X步，总共Y+1步）
知道"abcd"变成“fg”多少步（假设Z步），那么从"abcde"到"fgh"就是"abcde"->"fge"->"fgh"。（先不管最后一个字符，把前面的先变好，用了Z步，然后把最后一个字符给替换了。这里如果最后一个字符碰巧就一样，那就不用替换，省了一步）
以上三种方式算出来选最少的，就是答案。所以我们再看看定理二：

dp[i][j]=min(dp[i-1][j]+1,dp[i][j+1]+1,dp[i][j]+int(word1[i]!=word2[j]))
dp[i-1][j]：情况一
dp[i][j-1]+1：情况二
dp[i-1][j-1]+int(word1[i]!=word2[j])：情况三
有了定理二的递推公式，你就建立一个二维数组，考虑好空串的情况，总会写出来

-------------------------------------

进阶

-------------------------------------

先把二维数组的方法做出来，要还没做出来呢，先别往下看。

由定理二可知，dp[i][j]只和dp[i-1][j],dp[i][j-1],dp[i-1][j-1]三个量有关，即二维数组中，当前元素的左边，上边，左上角三个元素。

那我们不用这么大的二维数组存啊！我们就用一维数组，表示原来二维数组中的一行，然后我们就反复覆盖里面的值。dp[i-1][j]就是我当前左边的元素，dp[i][j-1]是没覆盖前我这里的值，dp[i-1][j-1]好像找不见了？那我们就单独用一个变量存着它，我们把它叫lu（left up），则代码为：

class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        m=len(word1)
        n=len(word2)
        dp=list(range(n+1))
        for i in range(m):
            lu=dp[0]
            dp[0]=i+1
            for j in range(n):
                dp[j+1],lu=min(dp[j]+1,dp[j+1]+1,lu+int(word1[i]!=word2[j])),dp[j+1]
        return dp[-1]
时间复杂度 ：O(mn)，其中 m 为 word1 的长度，n 为 word2 的长度

空间复杂度 ：O(n)

(这里可以比较word1和word2的长度，让n是m n里较小的那一个)
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        word1 = " " + word1;
        word2 = " " + word2;
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0 ; i < len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }
        return dp[len1 - 1][len2 - 1];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        EditDistance solution = new EditDistance();
        System.out.println(solution.minDistance(word1, word2));
    }
}
