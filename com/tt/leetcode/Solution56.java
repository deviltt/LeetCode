package com.tt.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        //对二维数组进行升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[][] result = new int[intervals.length][intervals[0].length];
        int[] temp = new int[intervals[0].length];
        temp[0] = intervals[0][0];
        temp[1] = intervals[0][1];
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > temp[1]) {
                result[index][0] = temp[0];
                result[index][1] = temp[1];
                ++index;
                temp[0] = intervals[i][0];
                temp[1] = intervals[i][1];
            } else {
                temp[0] = Math.min(temp[0], intervals[i][0]);
                temp[1] = Math.max(temp[1], intervals[i][1]);
            }
        }
        result[index][0] = temp[0];
        result[index++][1] = temp[1];
        int[][] ans = new int[index][intervals[0].length];
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                ans[i][j] = result[i][j];
            }
        }
        return ans;
    }
}
