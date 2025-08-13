/**
 * ClassName: practise
 * Package: PACKAGE_NAME
 * Description:
 *
 * @author jacksonling
 * @version 1.0
 * @Date 2025-08-03 21:34
 */
public class practise {
    public static void main(String[] args) {
        String content = "13888889999";
        if (content.matches("1(38|39)\\d{8}")){
            System.out.println("验证成功");
        }else {
            System.out.println("验证失败");
        }
    }
}
