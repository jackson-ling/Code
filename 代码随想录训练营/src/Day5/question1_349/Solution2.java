package Day5.question1_349;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        // 遍历数组一，添加到集合中
        for (int i : nums1) {
            set1.add(i);
        }
        // 遍历数组二，查找，把交集添加到 res 中
        for (int i : nums2) {
            if (set1.contains(i)) {
                res.add(i);
            }
        }

        // 转为数组返回
        int[] result = new int[res.size()];
        int index = 0;
        for (int i : res) {
            result[index] = i;
            index++;
        }
        // 返回结果数组
        return result;
    }
}
