package service;

import common.Message;
import common.MessageType;
import common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class UserClientService {

    // 因为可能需要在其他方法使用user信息
    private User u = new User();
    // 因为 socket 可能在其他地方使用，做成属性
    private Socket socket;

    boolean b = false;

    // 判断用户是否合法
    public boolean checkUser(String userId, String pwd) {

        boolean b = false;

        // 创建 User 对象
        u.setUserId(userId);
        u.setPasswd(pwd);

        try {
            socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 9999);

            // 发送 u 对象到服务器
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);

            // 读取服务端返回的 message 对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) ois.readObject();

            // 判断
            if (ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) { // 登录成功

                // 创建一个和服务端保持通信的线程
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                // 启动客户端线程
                clientConnectServerThread.start();
                // 为了方便管理线程，放到集合中
                ManagerClientConnectServerThread.addClientConnectSercerThread(userId, clientConnectServerThread);
                b = true;
            } else {
                // 登录失败，不启动线程，关闭 socket
                socket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    // 发送请求拉取用户列表
    public void onlineFriend(){
        // 发送一个 Message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getUserId()); //设置发送人

        try {
            // 从集合中通过 userId 得到对应的线程
            ClientConnectServerThread clientConnectServerThread = ManagerClientConnectServerThread.getClientConnectServerThread(u.getUserId());

            // 获取 socket
            Socket socket = clientConnectServerThread.getSocket();

            // 获取输出流
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            // 发送信息
            oos.writeObject(message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //编写方法，退出客户端，并给服务端发送一个退出系统的message对象
    public void logout() {
        // 构建 message 对象
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u.getUserId());//一定要指定我是哪个客户端id

        //发送message
        try {
            // 从集合中拿到线程，再拿到socket
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManagerClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
            System.out.println(u.getUserId() + " 退出系统 ");
            System.exit(0);//结束进程
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
