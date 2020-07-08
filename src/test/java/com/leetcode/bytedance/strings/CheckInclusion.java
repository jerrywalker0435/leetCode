package com.leetcode.bytedance.strings;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckInclusion {
    /*
给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。

换句话说，第一个字符串的排列之一是第二个字符串的子串。

示例1:

输入: s1 = "ab" s2 = "eidbaooo"
输出: True
解释: s2 包含 s1 的排列之一 ("ba").


示例2:

输入: s1= "ab" s2 = "eidboaoo"
输出: False


注意：

输入的字符串只包含小写字母
两个字符串的长度都在 [1, 10,000] 之间
     */

    @Test
    public void checkInclusion(){

        String s1 = "ab", s2 = "eidbaooo";

        String s3= "ab", s4 = "eidboaoo";
        assertTrue(so1(s1,s2));
        assertFalse(so1(s3,s4));
    }

    private boolean so1(String s1,String s2){
        if (s1 == null || s2 == null) {
            return false;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        int[] win1 = new int[26];
        int[] win2 = new int[26];

        for (int i = 0; i < len1; i++) {
            win1[s1.charAt(i)-'a']++;
        }

        for (int i = 0; i < len2; i++) {
            if(i>=len1){
                win2[s2.charAt(i-len1)-'a']--;
            }

            win2[s2.charAt(i)-'a']++;
            if (Arrays.equals(win1, win2)) {
                return true;
            }

        }

        return false;
    }


}
