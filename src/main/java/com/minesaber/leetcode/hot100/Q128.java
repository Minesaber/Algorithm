package com.minesaber.leetcode.hot100;

import java.util.HashSet;

/**
 * @author Minesaber
 */
public class Q128 {
    static int longestConsecutive(int[] nums) {
        int maxLength = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int tmp = num + 1;
                int max = 1;
                while (set.contains(tmp)) {
                    max++;
                    tmp++;
                }
                maxLength = Math.max(max, maxLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive(new int[]{1, 2, 0, 1}));
    }
}
