package Day5.question1_349;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 默认初值为 0
        int[] hash1 = new int[1002];
        int[] hash2 = new int[1002];

        // 限制了数据范围是 0 ~ 1000，直接把数值作为hash的下标

        // hash1
        for (int i = 0; i < nums1.length; i++) {
            hash1[nums1[i]]++;
        }

        // hash2
        for (int i = 0; i < nums1.length; i++) {
            hash2[nums2[i]]++;
        }

        List<Integer> relist = new ArrayList<>();
        for (int i = 0; i < 1002; i++) {
            if (hash1[i] > 0 && hash2[i] > 0) {
                relist.add(i); // 题目限制了数据范围，添加的就是数组中的值
            }
        }

        // 把结果转为数组返回
        int[] res = new int[relist.size()];
        int index = 0;

        // 这里只关心集合中的元素，可以使用增强for
        for (int i : relist) { // 表示从 relist 中取出一个元素，直到没有元素可取为止
            res[index] = i;
            index++;
        }
        return res;
    }
}
