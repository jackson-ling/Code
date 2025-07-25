package chapter_23.question_2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception{
        // 获取 Class 对象
        Class<?> cls = Class.forName("java.io.File");
        // 获取构造器对象
        Constructor<?>[] constructors = cls.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        // 调用指定构造器完成file对象的初始化
        String filePath = "C:\\Users\\jackson\\Desktop\\test.txt";
        Constructor<?> constructor = cls.getDeclaredConstructor(String.class);
        Object o = constructor.newInstance(filePath); // 这里只是得到了 File 对象

        // 创建文件
        Method method = cls.getMethod("createNewFile");
        method.invoke(o);
    }
}
