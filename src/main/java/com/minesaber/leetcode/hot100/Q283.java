package com.minesaber.leetcode.hot100;

import java.util.Arrays;

/**
 * @author Minesaber
 */
public class Q283 {
    static void moveZeroes(int[] nums) {
        if (nums.length <= 1)
            return;
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                swap(nums, i, j);
                i++;
            }
            j++;
        }
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 0, 3, 12};
        moveZeroes(array);
        System.out.println(Arrays.toString(array));
    }
}
