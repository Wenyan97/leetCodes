package com.leetcode3.DP;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
        });
        return 0;
    }
    
    public static void main(String[] args) {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                // return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
                return b[1] - a[1];

            }
        });
        for (int[] is : envelopes) {
            for (int i = 0; i < is.length; i++) {
                System.out.print(is[i] + " ");
            }
            System.out.println();
        }
    }
}
