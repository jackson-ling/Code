package Day1.question3_977;

public class Solution1 {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if(nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }
}

class Solution2{
    // 双指针思路
    public int[] sortedSquares(int[] nums) {
        /*
            由于平方后最大的值只可能是两边的值---> 用相撞指针
            排序后的数组要求是升序，从数组的最后开始往前遍历，一次为新数组添加元素
         */
        int i = 0;
        int j = nums.length - 1;
        int[] result = new int[nums.length];
        int index = result.length - 1;
        while(i <= j){  // 取等是不为了遗漏二者相等时指向的元素
            if(nums[i] * nums[i] > nums[j] * nums[j]){
                result[index] =  nums[i] * nums[i];
                index--;
                i++;
            }else{ // 包含了相等的情况
                result[index] =  nums[j] * nums[j];
                index--;
                j--;
            }
        }
        return result;
    }
}
