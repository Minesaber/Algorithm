package com.minesaber.leetcode.hot100;

import java.util.*;

/**
 * @author Minesaber
 */
public class Q49 {
    static List<List<String>> q2(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = sort(str);
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
                res.add(list);
            } else {
                List<String> list = map.get(key);
                list.add(str);
            }
        }
        return res;
    }

    static String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(q2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}