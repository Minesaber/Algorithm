package com.minesaber.leetcode.hot100;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Minesaber
 */
public class Q1 {
    static int[] q1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};
            else
                map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        System.out.println(Arrays.toString(q1(array, 9)));
    }
}
