package com.minesaber.leetcode.hot100;

import java.util.Arrays;

/**
 * @author Minesaber
 */
public class Q73 {
    static void setZeroes(int[][] matrix) {
        int l = matrix[0].length, h = matrix.length;
        boolean[] col = new boolean[l];
        boolean[] row = new boolean[h];
        for (int i = 0; i < h; i++)
            for (int j = 0; j < l; j++)
                if (matrix[i][j] == 0) col[j] = row[i] = true;
        for (int i = 0; i < h; i++)
            for (int j = 0; j < l; j++)
                if (row[i] || col[j]) matrix[i][j] = 0;
    }

    public static void main(String[] args) {
        int[][] values = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(values);
        System.out.println(Arrays.deepToString(values));
    }
}
