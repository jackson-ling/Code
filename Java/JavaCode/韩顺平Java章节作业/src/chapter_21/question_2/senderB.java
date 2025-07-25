package chapter_21.question_2;

import java.io.IOException;
import java.net.*;

public class senderB {
    public static void main(String[] args) throws IOException {

        System.out.println("发送端 B 启动...");

        DatagramSocket datagramSocket = new DatagramSocket(8887);

        // 1. 发送信息
        String send_info1 = "四大名著是哪些";
        String send_info2 = "你好";

        byte[] send_info = send_info1.getBytes();
        DatagramPacket sendPacket = new DatagramPacket
                (send_info, send_info.length, InetAddress.getByName("LAPTOP-E8O2B4GK"), 8888);

        datagramSocket.send(sendPacket);

        // 2. 接收信息
        byte[] buf = new byte[1024];
        DatagramPacket getPacket = new DatagramPacket(buf, buf.length);

        datagramSocket.receive(getPacket);

        // 数据解包
        byte[] get_info = getPacket.getData();
        int length = getPacket.getLength();

        // 打印数据
        String s = new String(get_info, 0,length);
        System.out.println("接收到信息：" + s);

        // 关闭资源
        datagramSocket.close();
    }
}
