package Day25.question_406;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 使用 lambda 表达式实现接口的抽象方法
        Arrays.sort(people, (a, b) -> {
            // 身高相同，k从小到大排序
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            // 身高按照从大到小排序
            return b[0] - a[0];
        });

        LinkedList<int[]> queue = new LinkedList<>();
        for (int[] p : people) {
            // add（index, value）
            queue.add(p[1],p);
        }

        return queue.toArray(new int[people.length][]);
    }
}
