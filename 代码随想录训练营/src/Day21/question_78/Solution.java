package Day21.question_78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> subsets(int[] nums) {
        subsetHelper(nums, 0);
        return result;
    }

    public void subsetHelper(int[] nums, int startIndex) {
        // 收获结果放在终止条件的上方，不会忽略最后一个元素
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            subsetHelper(nums, i + 1);
            // 回溯
            path.removeLast();
        }
    }
}
