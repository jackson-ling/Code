package practise;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: test
 * Package: practise
 * Description:
 *
 * @author jacksonling
 * @version 1.0
 * @Date 2025-08-11 15:22
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> collect = list.stream().filter(n -> n > 3).collect(Collectors.toList());
        System.out.println(collect);
    }
}
