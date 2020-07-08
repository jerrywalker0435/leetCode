package com.leetcode.bytedance.arrary;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /*
      三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。



示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
     */
    @Test
    public void threeSum() {
        System.out.println(solution(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    private List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums==null|| nums.length==0){
            return ans;
        }
        Arrays.sort(nums);

        for(int i = 0 ; i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            int low = i+1;
            int high = nums.length-1;
            int sum = 0 - nums[i];
            while(low<high){
                if(nums[low]+nums[high]==sum){
                    ans.add(Arrays.asList(nums[i],nums[low],nums[high]));
                    while(low<high && nums[low]==nums[low+1]) low++;
                    while(low<high && nums[high]==nums[high-1]) high--;
                    low ++;
                    high --;
                }else if ( nums[low]+ nums[high]< sum ){
                    low++;
                }else{
                    high--;
                }
            }


        }
        return ans;
    }
}
