package com.minesaber.leetcode.hot100;

/**
 * @author Minesaber
 */
public class Q53 {
    static int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int pre = 0, minPre = 0;
        for (int num : nums) {
            pre += num;
            if (pre - minPre > res)
                res = pre - minPre;
            if (pre < minPre)
                minPre = pre;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
