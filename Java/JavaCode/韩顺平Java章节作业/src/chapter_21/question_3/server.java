package chapter_21.question_3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws Exception {
        System.out.println("服务端启动...");

        ServerSocket serverSocket = new ServerSocket(8888);

        Socket socket = serverSocket.accept();  // 在 8888 处于监听状态

        // 1. 接收信息
        InputStream is = socket.getInputStream();
        InputStreamReader isReader = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isReader);
        String get_info = reader.readLine();
        System.out.println("接收到信息：" + get_info);

        // 2. 发送信息
        OutputStream os = socket.getOutputStream();

        // 高山流水音乐文件
        String dirPath = "C:\\Users\\jackson\\Desktop\\韩顺平Java课程资料\\资料\\分享资料\\高山流水.mp3";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(dirPath));
        byte[] send_info = StreamUtils.streamToByteArray(bis);

        // 默认音乐文件
        String other = "C:\\Users\\jackson\\Desktop\\韩顺平Java课程资料\\资料\\分享资料\\111.wav";
        BufferedInputStream bis_ = new BufferedInputStream(new FileInputStream(other));
        byte[] send_info_ = StreamUtils.streamToByteArray(bis_);

        // 判断接收信息，发送音乐文件
        if(get_info.equals("高山流水")){
            BufferedOutputStream bos = new BufferedOutputStream(os);
            bos.write(send_info);
            bos.flush();
            socket.shutdownOutput(); // 发送信息的结束标志
        }else{
            BufferedOutputStream bos = new BufferedOutputStream(os);
            bos.write(send_info_);
            bos.flush();
            socket.shutdownOutput(); // 发送信息的结束标志
        }

        // 关闭流
        bis_.close();
        bis.close();
        reader.close();
        serverSocket.close();
        socket.close();
    }
}
