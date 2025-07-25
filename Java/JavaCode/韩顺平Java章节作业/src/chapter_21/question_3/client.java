package chapter_21.question_3;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws Exception {
        System.out.println("客户端启动...");

        Socket socket = new Socket(InetAddress.getLocalHost(),8888);

        // 1. 发送信息
        OutputStream os = socket.getOutputStream(); // 获取 socket 输出流

        String send_info;
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个音乐名：");
        send_info = scanner.next();

        OutputStreamWriter osWriter = new OutputStreamWriter(os); // 转换流
        BufferedWriter writer = new BufferedWriter(osWriter);
        writer.write(send_info);
        writer.newLine(); // 发送信息的结束标志
        writer.flush(); // 一定要刷新才可以成功写入信息


        // 2. 接收信息
        InputStream is = socket.getInputStream(); // 获取 socket 输入流
        BufferedInputStream bis = new BufferedInputStream(is);
        byte[] get_info = StreamUtils.streamToByteArray(bis);

        // 保存音乐文件
        String dirPath = "C:\\Users\\jackson\\Desktop\\高山流水2.mp3";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dirPath));
        bos.write(get_info);

        // 关闭流
        bos.close();
        bis.close();
        writer.close();
        scanner.close();
        socket.close();
    }
}
