package chapter_21.question_1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动...");

        // 创建服务并在8888端口监听
        ServerSocket serverSocket = new ServerSocket(8888);

        // 创建 socket 对象，等待接收信息
        Socket socket = serverSocket.accept();


        // 1. 接收信息
        String get_info = null;
        String send_info = null;

        InputStream is = socket.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(is);
        int readLen = 0;
        byte[] buf = new byte[8];

        while ((readLen = bis.read(buf)) != -1) {
            get_info = new String(buf,0,readLen);
        }

        System.out.println("接收到信息：" + get_info);

        if(get_info.equals("name")){
            send_info = "我是jacksonling";
        }else if (get_info.equals("hobby")){
            send_info = "编写java程序";
        }else{
            send_info = "你说啥呢";
        }

        // 2. 发送信息
        OutputStream os = socket.getOutputStream();
        OutputStreamWriter osWriter = new OutputStreamWriter(os); // 使用转换流，发送字符
        BufferedWriter writer = new BufferedWriter(osWriter);
        writer.write(send_info);
        writer.newLine(); // 发送信息的结束标志

        // 3. 关闭资源（关闭最外层）
        writer.close();
        bis.close();
        socket.close();
        serverSocket.close();
    }
}
