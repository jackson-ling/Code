package RegularExpresstion;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: 命名捕获分组
 * Package: RegularExpresstion
 * Description:
 *
 * @author jacksonling
 * @version 1.0
 * @Date 2025-08-03 15:29
 */
public class test {
    public static void main(String[] args) {
        String content = "后端工程师";
        Pattern pattern = Pattern.compile("^[\u0391-\uffe5]+$");
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()){
            System.out.println("全部都是汉字");
        }else {
            System.out.println("有不是汉字的成分");
        }
    }
}
