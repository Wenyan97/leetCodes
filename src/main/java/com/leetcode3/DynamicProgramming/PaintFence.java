package com.leetcode3.DynamicProgramming;
/* 
思路：第一根栅栏有k种染色方案，第二根也有k种，前两根染色方案有k*k种。第三根栅栏染色有k-1种，若第三根栅栏染色和第二根栅栏不同，那么第三个染色和第一根染色没有关系，则前三根栅栏染色方案有k*k*(k-1)种；若第三根栅栏和第二根栅栏染色相同，那么要求第一个栅栏和第三根栅栏染色不同，则前三根栅栏染色方案有k*(k-1)。

递推：现在考虑前i根栅栏染色方案。

若第i根栅栏和第i-1根栅栏颜色不同，则第i根栅栏和第i-2根栅栏染色无关，设前i-1根栅栏染色方案为m[i-1]，此时第i根栅栏有k-1种染色可染，所以前i根染色方案有m[i-1]*(k-1)种。；

若第i根栅栏和第i-1根栅栏颜色相同，此时要求第i、i-1根栅栏和i-2根栅栏 颜色不同，设前i-2根栅栏染色方案为m[i-2]，此时第i根栅栏和第i-1根栅栏有k-1种染色可染，所以前i根染色方案有m[i-2]*(k-1)种。*/
public class PaintFence {
    public int numWays(int n, int k) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return k*k;
        } else {
            int[] m = new int[n];
            m[0] = k;
            m[1] = k*k;
            for (int i = 2; i < n; i++) {
                m[i] = m[i-1] * (k-1) + m[i-2] * (k-1);
            }
            return m[n-1];
        }
    }

    int maxa(int[] a, int l, int r) {
        if (r - l == 0) {
            return a[r];
        }
        int lmax = maxa(a, l, (l + r) / 2);
        int rmax = maxa(a, (l + r) / 2 + 1, r);
        System.out.println(rmax + " " + lmax);
        if (rmax < lmax) {
            return lmax;
        } else {
            return rmax;
        }
    }

    public static void main(String[] args) {
        int[] a = {10, 8, 6, 4, 2};
        PaintFence solution = new PaintFence();
        solution.maxa(a, 0, 4);
    }
}
