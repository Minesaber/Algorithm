package com.minesaber.carl.array;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Minesaber
 */
public class BinarySearch {
    /**
     * 获取有序的随机数数组
     *
     * @param size 个数
     * @param max  最大值
     * @return 有序的随机数数组
     */
    static int[] randomArray(int size, int max) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max + 1);
        }
        Arrays.sort(array);
        return array;
    }

    /**
     * 二分查找
     *
     * @param target 目标值
     * @return 目标的索引
     */
    static int binarySearch(int[] array, int target) {
        if (target < array[0] || target > array[array.length - 1])
            return -1;
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int midIndex = (left + right) / 2;
            int midValue = array[midIndex];
            if (target == midValue)
                return midIndex;
            if (target < midValue)
                right = midIndex - 1;
            else
                left = midIndex + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = randomArray(6, 7);
        int index = binarySearch(array, 7);
        System.out.println(Arrays.toString(array));
        System.out.println(index == -1 ? "目标值不存在" : "目标值索引为" + index);
    }
}
