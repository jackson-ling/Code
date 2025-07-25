package chapter_21.question_1;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;


public class client {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端启动...");

        // 创建 socket 对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        // 定义发送的信息
        String send_info1 = "name";
        String send_info2 = "hobby";
        String send_info3 = "你好";

        // 实现三个信息都要发送，使用数组循环读取发送信息
        String[] send_infos = new String[3];
        send_infos[0] = send_info1;
        send_infos[1] = send_info2;
        send_infos[2] = send_info3;


        // 1. 发送信息
        OutputStream os = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);

        bos.write(send_info3.getBytes());
        bos.flush(); // 如果使用 close() 会抛出异常
        socket.shutdownOutput(); // 发送信息的结束标志

        // 2. 接收信息
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr);
        String get_info = reader.readLine();
        System.out.println("接收到信息：" + get_info);

        // 3. 关闭资源（关闭最外层）
        reader.close();
        bos.close();
        socket.close();
    }
}
