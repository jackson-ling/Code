package Day26.question_452;

import java.util.Arrays;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        // 为了尽可能寻找重叠区间，按左边界从小到大排序
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[0],o2[0]));
        // 初始化弓箭数，至少为一个
        int count = 1;
        // 为了和 i - 1 的元素比较，防止索引越界，从 1 开始遍历
        for (int i = 1; i < points.length; i++) {
            // 下一个元素的左边界大于当前元素的右边界，不重叠
            if (points[i][0] > points[i - 1][1]) {
                count++;
            } else {
                // 更新最小右边界，看第i + 1 个元素是否重叠
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }
        return count;
    }
}
