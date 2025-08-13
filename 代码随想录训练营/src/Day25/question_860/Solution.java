package Day25.question_860;

public class Solution {
    public boolean lemonadeChange(int[] bills) {
        // 记录三种面额的张数
        int fiveNum = 0;
        int tenNum = 0;
        int twentyNum = 0;
        // 遍历
        for (int bill : bills) {
            // 情况一：收到面额为 5 的钞票
            if (bill == 5) {
                fiveNum++;
            }
            // 情况二：收到面额为 10 的钞票
            else if (bill == 10) {
                if (fiveNum <= 0) {
                    return false;
                }
                // 用一张 5 找零
                fiveNum--;
                tenNum++;
            }
            // 情况三：收到面额为 20 的钞票
            else if (bill == 20) {
                // 贪心：优先使用 10 + 5 找零
                if (fiveNum > 0 && tenNum > 0) {
                    tenNum--;
                    fiveNum--;
                }
                // 下策：使用 3 张 5 找零
                else if (fiveNum >= 3) {
                    fiveNum -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
