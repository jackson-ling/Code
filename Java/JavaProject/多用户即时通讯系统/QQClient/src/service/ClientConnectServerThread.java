package service;

import common.Message;
import common.MessageType;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientConnectServerThread extends Thread{

    private Socket socket;

    // 可以接收一个 socket 对象
    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // 在后台和服务器通讯
        while (true){
            System.out.println("等待读取服务端的信息...");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                // 如果服务端没有发送信息，线程会阻塞在这里
                Message message = (Message) ois.readObject();

                // 接收服务器回送的信息：在线用户列表
                if(message.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)){
                    // 取出在新列表信息
                    String[] onlineUsers = message.getContent().split(" ");
                    System.out.println("\n=======当前在线用户列表=======");
                    for (int i = 0; i < onlineUsers.length; i++) {
                        System.out.println("用户：" + onlineUsers[i]);
                    }
                }else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)){
                    System.out.println("\n" + message.getSender() + " 对 " + message.getGetter() + "说：" + message.getContent());
                }else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {
                    System.out.println("\n" + message.getSender() + "对大家说：" + message.getContent());
                }else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)){
                    System.out.println("\n" + message.getSender() + " 给 " + message.getGetter()
                            + " 发文件: " + message.getSrc() + " 到我的电脑的目录 " + message.getDest());
                    //取出message的文件字节数组，通过文件输出流写出到磁盘
                    FileOutputStream fileOutputStream = new FileOutputStream(message.getDest());
                    fileOutputStream.write(message.getFileBytes());
                    fileOutputStream.close();
                    System.out.println("\n 保存文件成功~");

                }
                else{
                    System.out.println("是其他类型的 message，暂时不处理...");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 为了更方便的得到 socket
    public Socket getSocket() {
        return socket;
    }

}
