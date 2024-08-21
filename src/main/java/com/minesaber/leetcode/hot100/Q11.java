package com.minesaber.leetcode.hot100;

/**
 * @author Minesaber
 */
public class Q11 {
    static int maxArea(int[] height) {
        if (height.length <= 1)
            return 0;
        int i = 0, j = height.length - 1, max = 0;
        while (i != j) {
            int size = cal(i, j, height[i], height[j]);
            if (size > max)
                max = size;
            if (height[i] > height[j])
                j--;
            else i++;
        }
        return max;
    }

    static int cal(int i, int j, int hi, int hj) {
        return (j - i) * Math.min(hi, hj);
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
