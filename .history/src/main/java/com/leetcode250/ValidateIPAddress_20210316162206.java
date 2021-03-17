package com.leetcode250;

public class ValidateIPAddress {
    public String validIPAddress(String IP) {
        char[] ipList = IP.toCharArray();
        return "";
    }

    public boolean isIPv4(char[] IP) {
        return true;
    }

    public static void main(String[] args) {
        String ip = "213.123.45.123";
        String[] s = ip.split(".");
        System.out.println(s);

    }
}
