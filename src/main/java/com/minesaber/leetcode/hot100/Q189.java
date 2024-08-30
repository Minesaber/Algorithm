package com.minesaber.leetcode.hot100;

import java.util.Arrays;

/**
 * @author Minesaber
 */
public class Q189 {
    static void rotate(int[] nums, int k) {
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            tmp[(i + k) % nums.length] = nums[i];
        System.arraycopy(tmp, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        rotate(array, 3);
        System.out.println(Arrays.toString(array));
    }
}
