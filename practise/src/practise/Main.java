package practise;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * ClassName: main
 * Package: practise
 * Description:
 *
 * @author jacksonling
 * @version 1.0
 * @Date 2025-08-02 15:41
 */
public class Main {
    public static void main(String[] args) {
        int[][] arr = {{1,1},{2,2},{3,3}};

    }
}

class test{
    @Test
    public void test0(){ // 普通写法
        List<String> list = Arrays.asList("北京", "南京", "天津", "东京", "西京", "普京");
        List<String> filterStrs = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterStrs);
    }

    @Test
    public void test1(){ // 使用 lambda 表达式
        List<String> list = Arrays.asList("北京", "南京", "天津", "东京", "西京", "普京");
        List<String> filterStrs = filterString(list, s -> s.contains("京"));
        System.out.println(filterStrs);
    }
    public List<String> filterString(List<String> list, Predicate<String> pre) {
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)) {
                filterList.add(s);
            }
        }
        return filterList;
    }
}

