package chapter_19.question_1;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String directoryPath = "E:\\mytemp";
        File file = new File(directoryPath);

        // 第一步
        if (!file.exists()) {
            // 创建文件
            if (file.mkdir()) {
                System.out.println("文件创建成功");
            } else {
                System.out.println("文件创建失败");
            }
        }

        // 第二步 + 第三步
        String filePath = "E:\\mytemp\\hello.txt";
        File newFile = new File(filePath);
        if (!newFile.exists()) {
            if (newFile.createNewFile()) { // 把异常抛出

                System.out.println("文件创建成功");

                // 第四步
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
                bos.write("hello,world~".getBytes());
                bos.close(); // 关闭流

            }else{
                System.out.println("文件创建失败");
            }
        } else {
            System.out.println("文件已经存在，不能重复创建");
        }
    }
}
