package com.leetcodes;

public class fibDemo {
    int fib(int N) {
        if (N == 1 || N == 2) return 1;
        return fib(N - 1) + fib(N - 2);
    }

    public static void main(String[] args) {
        fibDemo fib = new fibDemo();
        System.out.println(fib.fib(5));
    }
}
