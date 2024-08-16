package com.minesaber.algorithm.sort;

/**
 * @author Minesaber
 */
public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 获取分区点的索引
            int index = partition(arr, low, high);
            // 递归地对左右子数组再排序
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        // i为慢指针，记录比pivot小的元素放入的位置
        int i = low;
        // j为快指针，寻找比pivot小的元素
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                // 慢指针元素较小，已在位置上无需移动
                if (i == j) {
                    i++;
                    continue;
                }
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        // 基准元素放入合适位置
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 8, 9};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}