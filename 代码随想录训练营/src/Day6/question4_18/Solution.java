package Day6.question4_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();  // 结果集

        // 首先对数组排序
        Arrays.sort(nums);

        // 第一重循环，控制 k
        for (int k = 0; k < nums.length; k++) {
            // 剪枝：去掉不必要的计算
            if (nums[k] > target && nums[k] >= 0) {
                break;
            }
            // 对 k 去重
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }

            // 第二种循环，控制 i
            for (int i = k + 1; i < nums.length; i++) {
                // 剪枝：去掉不必要的计算
                if (nums[k] + nums[i] > target && nums[k] + nums[i] >= 0) {
                    break;
                }
                // 去重
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }

                // 双指针操作
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[k] + nums[i] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[k], nums[i], nums[left], nums[right]));
                        // c、d 去重
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        // 移动指针，寻找下一个符合条件的四元组
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
