package com;

public class QuickSort {
    public void quick_sort(int s[], int l, int r) {
        int temp;
        if (l < r) {
        //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j) {
                while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;  
                while(i < j && s[i] <= x) // 从左向右找第一个大于等于x的数
                    i++;  
                if(i < j) {
                    temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }
     
            }
            for (int k = 0; k < s.length; k++) {
                System.out.print(s[k] + " ");
            }
            System.out.println();
            s[l] = s[i];
            a[i] = x;
            quick_sort(s, l, i - 1); // 递归调用 
            quick_sort(s, i + 1, r);
        }
    }

    public static void main(String[] args) {
        QuickSort solution = new QuickSort();
        int[] s = {5,3,2,6,4,1,3,7};
        solution.quick_sort(s, 0, s.length - 1);
    }
}
