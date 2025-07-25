package Day1.question1_704;

class Solution1 { // 左闭右闭
    public int search(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1] 时多次循环运算
        if(target < nums[0] || target > nums[nums.length - 1]){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        // 因为 left = right 在区间上有意义，所以取等
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) { // 更新右区间
                right = mid - 1; // 由区间的定义知 mid 可以被取到，下一轮比较不希望再比较 mid
            } else if (nums[mid] < target) {// 更新左区间
                left = mid + 1;
            } else { // 此时 num[mid] = target，返回下标
                return mid;
            }
        }
        return -1; // 没有找到
    }
}

class Solution2 { /// 左闭右开
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length; // 因为区间的定义是右区间的值取不到
        while (left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target){
                right = mid; // 根据区间的定义 nums[mid] 的值取不到，在下一轮的搜索中就不会包含 nums[mid]
            }else if (nums[mid] < target){
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}