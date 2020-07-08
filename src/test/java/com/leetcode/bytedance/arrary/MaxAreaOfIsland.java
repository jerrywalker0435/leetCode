package com.leetcode.bytedance.arrary;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxAreaOfIsland {
   /*
   岛屿的最大面积
给定一个包含了一些 0 和 1 的非空二维数组 grid 。

一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。

找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)



示例 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。

示例 2:

[[0,0,0,0,0,0,0,0]]
对于上面这个给定的矩阵, 返回 0。



注意: 给定的矩阵grid 的长度和宽度都不超过 50。
    */
    @Test
    public void maxAreaOfIsland() {
        int[][] grid = new int[][] {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        assertEquals(4,solution(grid));
    }

    private int solution(int[][] grid) {
        int maxArea = 0;
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[row].length;col++){
                maxArea = Math.max(maxArea,area(grid,row,col));
            }
        }
        return maxArea;
    }

    private int area(int[][] grid,int row,int col){
        if( row<0||row>=grid.length||
                col<0||col>=grid[row].length ||
                grid[row][col]==0
        ){
            return 0;
        }
        grid[row][col]=0;
        int count = 1;
        count += area(grid,row+1,col);
        count += area(grid,row-1,col);
        count += area(grid,row,col+1);
        count += area(grid,row,col-1);
        return count;
    }
}
