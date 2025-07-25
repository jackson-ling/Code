package Day5.question3_202;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> res = new HashSet<>();
        /*
            1. 如果它等于一了，循环退出，是快乐数
            2. 如果出现了重复元素，循环退出了，此时就不是快乐数
         */
        while(n!=1 && !res.contains(n)){
            res.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    public int getNextNumber(int n) {
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }
        return sum;
    }

}
