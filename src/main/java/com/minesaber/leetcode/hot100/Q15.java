package com.minesaber.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Minesaber
 */
public class Q15 {
    static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int k = 0; k < length; k++) {
            if (nums[k] > 0)
                break;
            if (k != 0 && nums[k] == nums[k - 1])
                continue;
            int target = -nums[k];
            int j = length - 1;
            for (int i = k + 1; i < j; i++) {
                if (i != k + 1 && nums[i] == nums[i - 1])
                    continue;
                while (j > i + 1 && nums[i] + nums[j] > target)
                    j--;
                if (nums[i] + nums[j] == target) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[k]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    res.add(list);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}));
    }
}
