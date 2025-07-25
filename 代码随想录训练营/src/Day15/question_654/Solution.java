package Day15.question_654;

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // 区间：左闭右开
        return constructMaximumBinaryTree1(nums, 0, nums.length);
    }

    public TreeNode constructMaximumBinaryTree1(int[] nums, int leftIndex, int rightIndex) {
        // 没有元素了
        if (rightIndex - leftIndex < 1) {
            return null;
        }
        // 只有一个元素
        if (rightIndex - leftIndex == 1) {
            return new TreeNode(nums[leftIndex]);
        }
        // 最大值所在位置
        int maxIndex = leftIndex;
        // 最大值
        int maxVal = nums[maxIndex];
        // 循环遍历找到最大值，更新最大值和其下标索引
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (nums[i] > maxVal){
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        // 根据maxIndex划分左右子树（区间：左闭右开）
        root.left = constructMaximumBinaryTree1(nums, leftIndex, maxIndex);
        root.right = constructMaximumBinaryTree1(nums, maxIndex + 1, rightIndex);
        return root;
    }
}
