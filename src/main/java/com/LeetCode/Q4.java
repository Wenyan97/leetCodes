package com.LeetCode;

import java.util.Objects;
import java.util.Stack;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Q4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] resultArr = new int[length];
        for (int i = 0; i < nums1.length; i++){
            return 7;
        }
        return 0;
    }

    public static void main(String[] args) {
        String hex = toHex(12500);
        System.out.println(hex);
        if (hex.equals("30D4")) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }
    }

    static String toHex(int n) {
        String str = "";
        Stack<String> stack = new Stack<>();
        while(n / 16 != 0){
            switch (n % 16){
                case 10 : stack.push("A"); break;
                case 11 : stack.push("B"); break;
                case 12 : stack.push("C"); break;
                case 13 : stack.push("D"); break;
                case 14 : stack.push("E"); break;
                case 15 : stack.push("F"); break;
                default : stack.push(String.valueOf(n % 16));
            }
            n = n / 16;
        }
        stack.push(String.valueOf(n));
        while(stack.size() != 0){
            str += stack.pop();
        }

        return str;
    }

}

class Message {
    public final int sequence;
    public final String text;
    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }
    public boolean equals(Object o){

        if (o instanceof Message){

            Message m = (Message) o;

            return Objects.equals(m.sequence, this.sequence);

        }

        return false;

    }

    public int hashCode(){

        return Objects.hash(sequence);

    }
}

class Person {
    public String name;
    Person(String name) {
        this.name = name;
    }
    public String toString() {
        return "{Person: " + name + "}";
    }
}
