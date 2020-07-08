package com.leetcode.bytedance.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MultiplyString {
/*

 字符串相乘
给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"
示例 2:

输入: num1 = "123", num2 = "456"
输出: "56088"
说明：

num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。

 */

    @Test
    public void solution() {
        assertEquals("56088",multiplyString("123","456"));
    }

    public String multiplyString(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "0";
        }
        int len1 = num1.length(), len2 = num2.length();
        int[] ans = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int mul1 = num1.charAt(i) - '0';
                int mul2 = num2.charAt(j) - '0';
                int mul = mul1 * mul2;
                int posLow = i + j + 1;
                int posHigh = i + j;
                mul += ans[posLow];
                ans[posLow] = mul % 10;
                ans[posHigh] += mul / 10;
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int num : ans) {
            if (sb.length() != 0 || num != 0) {
                sb.append(num);
            }
        }
        return sb.toString();
    }
}
