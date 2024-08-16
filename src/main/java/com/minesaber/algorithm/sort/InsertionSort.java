package com.minesaber.algorithm.sort;

/**
 * @author Minesaber
 */
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        // 外层循环控制插入的轮次（总共n-1轮），i记录当前无序部分的首个元素的索引
        for (int i = 1; i < n; ++i) {
            // 待安排的元素
            int key = arr[i];
            // 待安排的元素的位置
            int j = i;
            // 执行插入排序
            while (j >= 1 && arr[j - 1] > key) {
                arr[j] = arr[j - 1];
                j = j - 1;
            }
            arr[j] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 8, 9};
        insertionSort(arr);
        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
