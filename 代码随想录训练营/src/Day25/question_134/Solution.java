package Day25.question_134;


public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // i从0开始累加rest[i]，和记为curSum
        int curSum = 0;
        // 记录总油耗，判断能否走一圈
        int totalSum = 0;
        // 保存起点
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            // curSum < 0，说明[0, i]区间都不能作为起始位置
            // 因为这个区间选择任何一个位置作为起点，到i这里都会断油
            if (curSum < 0) {
                // 更新起点
                index = (i + 1) % gas.length;
                curSum = 0;
            }
        }
        if (totalSum < 0) {
            return -1;
        }
        return index;
    }
}
