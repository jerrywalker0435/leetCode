package com.leetcode.bytedance.strings;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LongestCommonPrefix {
    /*
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。
     */


    @Test
    public void solution(){

        String[] s1 = {"flower", "flow", "flight"};
        String[] s2 = {"dog", "racecar", "car"};
        assertEquals("fl", solution2(s1));
        assertEquals("", solution2(s2));
    }
    private String solution1(String[] strs){
        if (strs==null || strs.length==0) {
            return "";
        }
        String prefix = strs[0];
        for (String str:strs) {
            while (str.indexOf(prefix)!=0){
                prefix = prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }

    private String solution2(String[] strs){
        if (strs == null || strs.length==0) {
            return "";
        }
        String head = strs[0];
        String tail = strs[strs.length - 1];

        Arrays.sort(strs);

        while (head.indexOf(tail)!=0){
            tail = tail.substring(0, tail.length() - 1);
        }
        return tail;
    }

}
