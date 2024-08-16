package com.minesaber.algorithm.sort;

/**
 * @author Minesaber
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        // 外层循环控制冒泡的轮次（总共n-1轮），i记录已完成冒泡的元素的个数
        for (int i = 0; i < n - 1; i++) {
            // 内存循环进行每轮的多次比较
            for (int j = 0; j < n - 1 - i; j++) {
                // 如果前大后小，则交换
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 8, 9};
        bubbleSort(arr);
        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}