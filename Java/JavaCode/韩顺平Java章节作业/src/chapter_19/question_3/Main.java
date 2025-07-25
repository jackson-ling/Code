package chapter_19.question_3;

import java.io.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 配置文件路径
        String filePath = "C:\\Users\\jackson\\Desktop\\dog.properties";

        // 创建 properties 对象
        Properties properties = new Properties();

        // 创建 FileReader 对象，用于配置文件的加载
        FileReader fileReader = new FileReader(filePath);

        // 加载配置文件
        properties.load(fileReader);

        // 根据键值获取信息
        String name = properties.getProperty("name");
        String age = properties.getProperty("age");
        String color = properties.getProperty("color");

        // 变量类型转换
        Integer integer = Integer.parseInt(age);
        int dogAge = integer; // 自动拆箱

        // Dog 类属性的初始化
        Dog dog = new Dog(name, dogAge , color);

        // 序列化到文件中
        String dirPath = "C:\\Users\\jackson\\Desktop\\dog.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dirPath));
        oos.writeObject(dog);
        oos.close();

        // 反序列化，输出内容检查结果
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dirPath));
        Dog dog1 = (Dog)ois.readObject();
        System.out.println(dog1);
        ois.close();

    }
}

// 序列化的对象需要实现 Serializable 接口
class Dog implements Serializable{
    String name;
    int age;
    String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}