package RegularExpresstion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: test
 * Package: RegularExpresstion
 * Description:
 *
 * @author jacksonling
 * @version 1.0
 * @Date 2025-08-02 20:24
 */
public class Main {
    public static void main(String[] args) {
        // 匹配内容
        String content = "_ Aa124563bB@";

        // 创建模式对象（即正则表达式对象）

        // 第一组
        Pattern pattern = Pattern.compile("[0-3]"); // 只匹配 0-3 范围的字符
        /*
            匹配内容：1
            匹配内容：2
            匹配内容：3
         */

        // 第二组
//        Pattern pattern = Pattern.compile("[^0-3]"); // 除了 0-3 范围的字符都匹配
        /*
            匹配内容：_
            匹配内容：
            匹配内容：A
            匹配内容：a
            匹配内容：4
            匹配内容：5
            匹配内容：6
            匹配内容：b
            匹配内容：B
            匹配内容：@
         */

        // 第三组
//        Pattern pattern = Pattern.compile("[a-b]"); // 只匹配 a-b 范围的字符
        /*
            匹配内容：a
            匹配内容：b
         */

        // 第四组
//        Pattern pattern = Pattern.compile("[^a-b]"); // 除了 a-b 范围的字符都匹配
        /*
            匹配内容：_
            匹配内容：
            匹配内容：A
            匹配内容：1
            匹配内容：2
            匹配内容：4
            匹配内容：5
            匹配内容：6
            匹配内容：3
            匹配内容：B
            匹配内容：@
         */

        // 第五组
//        Pattern pattern = Pattern.compile("."); // 匹配所有字符
        /*
            匹配内容：_
            匹配内容：
            匹配内容：A
            匹配内容：a
            匹配内容：1
            匹配内容：2
            匹配内容：4
            匹配内容：5
            匹配内容：6
            匹配内容：3
            匹配内容：b
            匹配内容：B
            匹配内容：@
         */

        // 第六组
//        Pattern pattern = Pattern.compile("\\d"); // 只匹配 0-9 的字符
        /*
            匹配内容：1
            匹配内容：2
            匹配内容：4
            匹配内容：5
            匹配内容：6
            匹配内容：3
         */

        // 第七组
//        Pattern pattern = Pattern.compile("\\D"); // 匹配除了0-9 的字符
        /*
            匹配内容：_
            匹配内容：
            匹配内容：A
            匹配内容：a
            匹配内容：b
            匹配内容：B
            匹配内容：@
         */

        // 第八组
//        Pattern pattern = Pattern.compile("\\w"); // 匹配数字、下划线、大小写字符
        /*
            匹配内容：_
            匹配内容：A
            匹配内容：a
            匹配内容：1
            匹配内容：2
            匹配内容：4
            匹配内容：5
            匹配内容：6
            匹配内容：3
            匹配内容：b
            匹配内容：B
         */
//        // 第九组
//        Pattern pattern = Pattern.compile("\\W"); // 匹配除了数字、下划线、大小写字符
        /*
            匹配内容：
            匹配内容：@
         */
//        // 第十组
//        Pattern pattern = Pattern.compile("\\s"); // 匹配任何空白字符(空格,制表符等)
        /*
            匹配内容：
         */
//        // 第十一组
//        Pattern pattern = Pattern.compile("\\S"); // 匹配除了任何空白字符(空格,制表符等)
        /*
            匹配内容：_
            匹配内容：A
            匹配内容：a
            匹配内容：1
            匹配内容：2
            匹配内容：4
            匹配内容：5
            匹配内容：6
            匹配内容：3
            匹配内容：b
            匹配内容：B
            匹配内容：@
         */

        // 创建匹配器
        Matcher matcher = pattern.matcher(content);
        // 开始匹配
        while (matcher.find()){
            System.out.println("匹配内容：" + matcher.group(0));
        }
    }
}
