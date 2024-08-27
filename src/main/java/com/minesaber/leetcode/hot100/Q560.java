package com.minesaber.leetcode.hot100;

import java.util.HashMap;

/**
 * @author Minesaber
 */
public class Q560 {
    /**
     * 方法一：枚举
     */
    static int subarraySum_method1(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k)
                    res++;
            }
        }
        return res;
    }

    /**
     * 方法二：前缀和 + 哈希表
     */
    static int subarraySum_method2(int[] nums, int k) {
        int res = 0, pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (map.containsKey(pre - k))
                res += map.get(pre - k);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum_method1(new int[]{1, 2, 3}, 3));
        System.out.println(subarraySum_method2(new int[]{1, 2, 3}, 3));
    }
}
