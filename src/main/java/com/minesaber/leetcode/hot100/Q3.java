package com.minesaber.leetcode.hot100;

import java.util.HashSet;

/**
 * @author Minesaber
 */
public class Q3 {
    static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length < 2)
            return length;
        int maxLength = 1;
        HashSet<Character> set = new HashSet<>();
        int j = -1;
        for (int i = 0; i < length; i++) {
            if (i != 0)
                set.remove(s.charAt(i - 1));
            while (j + 1 < length && !set.contains(s.charAt(j + 1))) {
                set.add(s.charAt(j + 1));
                j++;
            }
            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
