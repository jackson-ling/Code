package Day26.question_435;

import java.util.Arrays;

public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 和射气球那题差不多，本质都是采用处理重叠区间的思路

        // 按左区间排序，尽可能出现多的重叠区间
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 0;
        //  为了和 i - 1 比较，从 1 开始，避免下标越界
        for (int i = 1; i < intervals.length; i++) {
            // 区间重叠，更新最小右边界，目的是判断 i + 1 是否重叠，移除区间加一
            if (intervals[i][0] < intervals[i-1][1]){
                intervals[i][1] = Math.min(intervals[i -1][1],intervals[i][1]);
                count++;
            }
        }
        return count;
    }
}
