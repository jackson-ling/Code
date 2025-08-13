package Day19.question_77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
        return result;
    }

    // 回溯逻辑
    public void backtracking(int n,int k,int starIndex){
        // 终止条件
        if (path.size() == k){
            result.add(new ArrayList<>(path)); // 把路径加入结果集中
            return;
        }
        // 从 1 开始，这里取等
        for (int i = starIndex; i <= n; i++) {
            path.add(i);
            // 递归搜索，从下一个位置开始（因为是组合，不能重复使用同一个数字）
            backtracking(n,k,i + 1);
            // 回溯过程：弹出最后一个元素，和其他元素继续组合，寻找符合条件的结果
            path.removeLast();
        }
    }
}
