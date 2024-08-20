package com.minesaber.interview.structure.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Minesaber
 *
 * <p>链表排序
 */
public class LinkedListSorter {
    /**
     * 方法一：将链表转换为数组再排序
     */
    static void sortByArray(Node head) {
        if (head == null) return;
        // 将链表节点的值存入数组
        List<Integer> values = new ArrayList<>();
        Node current = head;
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }
        current = head;
        Collections.sort(values);
        for (int value : values) {
            current.val = value;
            current = current.next;
        }
    }

    /**
     * 打印链表
     */
    private static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);
        System.out.println("方法一：将链表转换为数组再排序");
        System.out.println("排序前：");
        printList(head);
        sortByArray(head);
        System.out.println("排序后：");
        printList(head);
    }
}