package Day18.question_108;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = traversal(nums, 0, nums.length - 1);
        return root;
    }
    // 左闭右闭区间[left, right]
    private TreeNode traversal(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + ((right - left) >> 1); // 找到中间节点
        TreeNode root = new TreeNode(nums[mid]); // 中间节点作为根节点
        root.left = traversal(nums, left, mid - 1); // 递归创建左子树
        root.right = traversal(nums, mid + 1, right); // 递归创建右子树
        return root;
    }
}
