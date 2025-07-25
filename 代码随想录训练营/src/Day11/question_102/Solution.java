package Day11.question_102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    // 层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        checkFun02(root);
        return resList;
    }

    public void checkFun02(TreeNode node) {
        if (node == null) return;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(node); // 入队
        // 遍历每一层的元素
        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<Integer>(); // 存储每一层的遍历结果
            int len = que.size();  // 记录当前层遍历的个数，明确出队个数
            while (len > 0) {
                TreeNode tmpNode = que.poll(); // 出队，返回队头元素
                itemList.add(tmpNode.val); // 添加遍历结果
                // 处理左孩子
                if (tmpNode.left != null) {
                    que.offer(tmpNode.left); // 左孩子入队
                }
                // 处理右孩子
                if (tmpNode.right != null) {
                    que.offer(tmpNode.right); // 右孩子入队
                }
                len--;
            }
            // 返回结果集
            resList.add(itemList);
        }
    }
}

class TreeNode {
    int val; // 根节点值
    TreeNode left; // 左孩子
    TreeNode right; // 右孩子

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}