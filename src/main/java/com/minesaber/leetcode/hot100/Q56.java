package com.minesaber.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Minesaber
 */
public class Q56 {
    static int[][] merge(int[][] intervals) {
        ArrayList<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        int i = 0;
        while (i < intervals.length) {
            int max = intervals[i][1];
            int j = i;
            while (j + 1 < intervals.length && intervals[j + 1][0] <= max) {
                if (intervals[j + 1][1] > max)
                    max = intervals[j + 1][1];
                j++;
            }
            res.add(new int[]{intervals[i][0], max});
            i = j + 1;
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }
}
