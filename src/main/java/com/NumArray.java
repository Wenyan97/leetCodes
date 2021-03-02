package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumArray {
    List<Integer> list;
    public NumArray(int[] nums) {
        this.list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
    }
    
    public int sumRange(int i, int j) {
        int sum = 0;
        for (int index = i; index <= j; index++) {
            sum += list.get(index);
        }
        return sum;
    }

}
