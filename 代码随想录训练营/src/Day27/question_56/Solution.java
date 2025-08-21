package Day27.question_56;


import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        // 按照左边界排序
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        // 用 start 和 end 维护当前合并的区间范围
        int start = intervals[0][0];
        int end = intervals[0][1];
        // 从第二个区间开始遍历
        for (int i = 1; i < intervals.length; i++) {
            // 不重叠（左区间大于右区间）
            if (intervals[i][0] > end){
                res.add(new int[]{start,end});
                // 更新当前区间，和下一个区间比较
                start = intervals[i][0];
                end = intervals[i][1];
            }else {
                // 重叠了，更新最大右区间，相当于合并区间
                end = Math.max(end,intervals[i][1]);
            }
        }
        // 遍历结束，把最后更新的区间添加到结果集
        res.add(new int[]{start,end});
        // 转为二维数组返回
        return res.toArray(new int[res.size()][]);
    }
}
