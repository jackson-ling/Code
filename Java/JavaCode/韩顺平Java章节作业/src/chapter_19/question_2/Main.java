package chapter_19.question_2;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 题目要求
        String filePath = "C:\\Users\\jackson\\Desktop\\file2.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        int cnt = 1;
        String line;
        while((line = br.readLine())!=null){
            System.out.println(cnt + " " + line);
            cnt++;
        }
        br.close();

        // 附加要求：转换流的应用(字节 --> 字符)
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath),"gbk");
        BufferedReader bfr = new BufferedReader(isr);
        while((line = bfr.readLine())!=null){
            System.out.println(cnt + " " + line);
            cnt++;
        }
        bfr.close();
    }
}
