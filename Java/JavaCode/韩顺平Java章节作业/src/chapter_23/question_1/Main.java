package chapter_23.question_1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception{
        // 获取 Class 对象
        Class<?> cls = Class.forName("chapter_23.question_1.PrivateTest");
        // 创建实例
        Object o = cls.newInstance();

        // 构建 Field 对象
        Field field = cls.getDeclaredField("name");
        // 反射爆破
        field.setAccessible(true);
        // 设置新的 name
        field.set(o,"jack");

        // 构建 Method 对象
        Method method = cls.getMethod("getName");
        Object invoke = method.invoke(o); // 返回值均用 Object 接收
        System.out.println(invoke);
    }
}
