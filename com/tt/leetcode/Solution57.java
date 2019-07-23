package com.tt.leetcode;

/**
 * 57. 插入区间
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0){
            intervals=new int[1][2];
            intervals[0][0]=newInterval[0];
            intervals[0][1]=newInterval[1];
            return intervals;
        }

        int[][] result = new int[intervals.length + 1][intervals[0].length];
        int index = 0;
        int resultIndex=0;
        while (index < intervals.length && intervals[index][1] < newInterval[0]) {
            result[resultIndex][0] = intervals[index][0];
            result[resultIndex][1] = intervals[index][1];
            ++resultIndex;
            ++index;
        }
        while (index < intervals.length && newInterval[1] >= intervals[index][0]) {
            newInterval[0] = Math.min(intervals[index][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[index][1], newInterval[1]);
            ++index;
        }
        result[resultIndex][0] = newInterval[0];
        result[resultIndex++][1] = newInterval[1];
        while (index < intervals.length) {
            result[resultIndex][0] = intervals[index][0];
            result[resultIndex++][1] = intervals[index][1];
            index++;
        }
        int[][] ans=new int[resultIndex][intervals[0].length];
        for(int i=0;i<resultIndex;i++){
            for(int j=0;j<intervals[0].length;j++){
                ans[i][j]=result[i][j];
            }
        }
        return ans;
    }
}
