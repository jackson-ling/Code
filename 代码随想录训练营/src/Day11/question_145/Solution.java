package Day11.question_145;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        preorder(root, result);
        return result;
    }
    // 中序遍历
    public void preorder(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        // 左
        preorder(root.left,result);
        // 根
        result.add(root.val);
        // 右
        preorder(root.right,result);
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

    TreeNode(int val,TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}