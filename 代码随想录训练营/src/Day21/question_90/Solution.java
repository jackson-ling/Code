package Day21.question_90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 首先对数组排序，方便判断在树层上是否选取重复元素
        Arrays.sort(nums);
        subsetWithDupHelper(nums,0);
        return res;
    }

    public void subsetWithDupHelper(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            // 树层去重
            if (i> startIndex && nums[i- 1] == nums[i]){
                continue;
            }
            path.add(nums[i]);
            subsetWithDupHelper(nums, i + 1);
            // 回溯
            path.removeLast();
        }
    }
}
