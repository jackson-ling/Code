package chapter_27.question_1;

public class Main {
    public static void main(String[] args) {
        String content = "jackson@qq.com";
        /*
            1. 使用 matches 方法，最好加上起始符和结束符
            2. @ 固定
            3. @前面的内容：可能是 大小写字母、数字、下划线（用\\w），还有-
            4. @后面的内容：可能是二级域名，即一个到多个字母，考虑大小写（用[a-zA-Z]）
            5. + 表示一个到多个
         */
        String regStr = "^[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+$";
        if (content.matches(regStr)){
            System.out.println("匹配成功");
        }else {
            System.out.println("匹配失败");
        }
    }
}
