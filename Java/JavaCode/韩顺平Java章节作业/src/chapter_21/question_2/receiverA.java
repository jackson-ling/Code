package chapter_21.question_2;

import java.io.IOException;
import java.net.*;

public class receiverA {
    public static void main(String[] args) throws IOException {
        System.out.println("接收端 A 启动...");

        DatagramSocket datagramSocket = new DatagramSocket(8888);

        // 1. 接收信息

        // 创建 DatagramPacket 对象
        byte[] buf = new byte[1024];
        DatagramPacket getPacket = new DatagramPacket(buf, buf.length);
        datagramSocket.receive(getPacket);

        // 数据解包
        byte[] get_info = getPacket.getData();
        int length = getPacket.getLength();
        String s = new String(get_info, 0, length);
        System.out.println("接收到信息：" + s);

        // 2. 发送信息

        // 定义发送信息
        String send_info1 = "四大名著是《红楼梦》、《三国演义》、《水浒传》、《西游记》";
        String send_info2 = "what?";

        // 对接收的信息判断
        if(s.equals("四大名著是哪些")){
            byte[] send_info = send_info1.getBytes();
            DatagramPacket sendPacket = new DatagramPacket
                    (send_info, send_info.length, InetAddress.getByName("LAPTOP-E8O2B4GK"), 8887);
            datagramSocket.send(sendPacket);
        }else{
            byte[] send_info = send_info2.getBytes();
            DatagramPacket sendPacket = new DatagramPacket
                    (send_info, send_info.length, InetAddress.getByName("LAPTOP-E8O2B4GK"), 8887);
            datagramSocket.send(sendPacket);
        }

        // 关闭资源
        datagramSocket.close();
    }
}
