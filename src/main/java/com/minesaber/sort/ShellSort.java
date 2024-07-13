package com.minesaber.sort;

/**
 * @author Minesaber
 */
public class ShellSort {
    public static void shellSort(int[] arr) {
        int n = arr.length;
        // 选择增量序列并逐渐减小增量
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // 外层循环控制所有增量序列，i记录当前序列的无序部分的首个元素的索引
            for (int i = gap; i < n; i++) {
                // 待安排的元素
                int key = arr[i];
                // 待安排的元素的位置
                int j = i;
                // 在当前序列中执行插入排序
                while (j >= gap && arr[j - gap] > key) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = key;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 8, 9};
        shellSort(arr);
        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
