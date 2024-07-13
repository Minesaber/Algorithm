package com.minesaber.sort;

/**
 * @author Minesaber
 */
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        // 外层循环控制选择的轮次（总共n-1轮），i记录当前无序部分的首个元素的索引
        for (int i = 0; i < n - 1; i++) {
            // 记录最小值元素的索引
            int minIdx = i;
            // 尝试更新索引
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // 更新有序部分
            if (minIdx != i) {
                int temp = arr[minIdx];
                arr[minIdx] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 8, 9};
        selectionSort(arr);
        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}