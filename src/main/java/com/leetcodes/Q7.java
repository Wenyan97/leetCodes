package com.leetcodes;

public class Q7 {
    public int reverse(int x) {
        int num = 0;
        int temp = x;
        while (temp == 0) {
            temp = temp / 10;
            num ++;
        }
        return num;
    }

    public static void main(String[] args) {
        Q7 solution = new Q7();
        System.out.println(solution.reverse(-123));
    }
}
