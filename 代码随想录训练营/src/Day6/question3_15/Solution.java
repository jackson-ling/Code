package Day6.question3_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        // 首先对数组排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 数组已经排序了，如果前面的数大于零，则后面的数肯定比前面大，不可能出现结果为0的三元组
            if(nums[i] > 0){
                return result;
            }

            // 去重 a（i > 0是为了保证 i-1 不会数组越界）
            if(i > 0 && nums[i-1] == nums[i]){
                continue; // 暂停一次循环，利用下一次循环让指针 i 后移
            }

            int left = i + 1;
            int right = nums.length - 1;

            // 这里不能取等，题目要求的是一个三元组，取等后 b、c 就变成一个元素了
            while (left < right) {
                // 判断和，移动指针
                if(nums[i] + nums[left] + nums[right] < 0){
                    left++;
                }else if (nums[i] + nums[left] + nums[right] > 0){
                    right--;
                }else{
                    // 运用 asList 方法将一维数转成-->集合
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 此时三元组的和为0，找到了一个符合条件的三元组，现在需要对 b、c 去重
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    // 继续移动指针，找到下一个符合条件的三元组
                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
