package Day1.question2_27;

public class Solution1 {
    // 暴力 for 循环
    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < size; j++) {
                    nums[j - 1] = nums[j];
                }
                i--; // 元素整体前移一位
                size--; // 删除一个 val，更新数组大小
            }
        }
        return size;
    }
}

class Solution2 {
    // 双指针
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}