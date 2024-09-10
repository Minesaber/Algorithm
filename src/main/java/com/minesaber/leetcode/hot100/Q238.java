package com.minesaber.leetcode.hot100;

import java.util.Arrays;

/**
 * @author Minesaber
 */
public class Q238 {
    static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1, tmp = 1; i < nums.length; i++)
            tmp = res[i] = tmp * nums[i - 1];
        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            res[i] = res[i] * tmp;
            tmp *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
