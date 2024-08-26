package com.minesaber.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Minesaber
 */
public class Q438 {
    static List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        ArrayList<Integer> res = new ArrayList<>();
        if (sLen < pLen)
            return res;
        int[] pArray = new int[26];
        int[] curArray = new int[26];
        for (int i = 0; i < pLen; i++) {
            pArray[p.charAt(i) - 'a']++;
            curArray[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(pArray, curArray))
            res.add(0);
        for (int i = 0; i < sLen - pLen; i++) {
            curArray[s.charAt(i) - 'a']--;
            curArray[s.charAt(i + pLen) - 'a']++;
            if (Arrays.equals(pArray, curArray))
                res.add(i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
