package com.leetcode.bytedance.strings;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    /*
     复原IP地址
给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。



示例:

输入: "25525511135"
输出: ["255.255.11.135", "255.255.111.35"]


     */
    List<String> ips = new ArrayList<>();

    @Test
    public void restoreIpAddresses() {
        System.out.println( solution("25525511135"));;
    }

    private List<String> solution(String s) {
        if(s==null || s.isEmpty()){
            return ips;
        }

        restoreIp(s,0,4,"");
        return ips;
    }

    private void restoreIp(String s,int index,int remain,String cur){
        if(remain==0){
            if(index==s.length()){
                ips.add(cur);
            }
            return;
        }

        for(int i=1;i<=3;i++){
            if(index+i>s.length()) break;
            if(i !=1 && s.charAt(index)=='0') break;

            String temp = s.substring(index,index+i);
            int val = Integer.valueOf(temp);
            if(val<=255){
                restoreIp(s,index+i,remain-1,cur+temp+(remain==1?"":"."));
            }

        }

    }
}
