package Day6.question1_454;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 存放结果值
        int res = 0;

        // 先对 num1 和 num2 遍历，合并为一个map
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                // key 存放和，value 存放相同的和出现的次数，即有多少种组合方式
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        // 后对 num3 和 num4 遍历，在 map 中查找是否出现过
        for (int i : nums3) {
            for (int j : nums4) {
                int gap = 0 - (i + j);
                // 注意：加上的是 key 对应的 value，存放的是某个和有几种组合可以实现
                res += map.getOrDefault(gap,0);
            }
        }
        return res;
    }
}
