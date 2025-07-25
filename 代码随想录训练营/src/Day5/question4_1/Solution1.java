package Day5.question4_1;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    // 使用 hash
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2]; // 存放结果下标
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            // 判断是否出现过
            if(map.containsKey(temp)){
                res[0] = i;
                res[1] = map.get(temp); // 通过指定键值返回对应的值
                break; // 因为题目说了只会有一个结果
            }
            // 如果没有出现过就放到集合中
            map.put(nums[i],i);
        }
        return res;
    }
}
