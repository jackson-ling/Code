package service;

import common.Message;
import common.MessageType;
import common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class QQServer {

    private ServerSocket ss =null;

    // 创建一个集合，存放多个用户
    private static HashMap<String,User> validUsers = new HashMap<>();

    static { // 静态代码块，类加载时会初始化 validUsers
        validUsers.put("科比一号",new User("科比一号","123456"));
        validUsers.put("科比二号",new User("科比二号","123456"));
        validUsers.put("300",new User("300","123456"));
        validUsers.put("jacksonling",new User("jacksonling","123456"));
    }

    // 验证用户是否有效
    private boolean checkUser(String userId,String passwd){
        User user = validUsers.get(userId);
        // 用户不存在
        if(user == null){
            return false;
        }
        // 用户存在，密码错误
        if(!user.getPasswd().equals(passwd)){
            return false;
        }
        return true;
    }

    public  QQServer(){
        // 注意：端口可以写在配置文件
        System.out.println("服务器在 9999 端口监听...");
        try {
            // 启动线程：服务器推送信息
            new Thread(new SendNewsToAllService()).start();
            ss = new ServerSocket(9999);
            // 监听多个客户端
            while (true){
                Socket socket = ss.accept(); // 如果没有客户端连接，就会阻塞
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                User u = (User)ois.readObject();

                // 创建 Message 对象，回复客户端信息
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                Message message = new Message();

                // 验证登录
                if(checkUser(u.getUserId(),u.getPasswd())){ // 登录成功
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    oos.writeObject(message);
                    // 创建线程和客户端保持通讯
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(socket, u.getUserId());
                    serverConnectClientThread.start(); // 启动线程
                    // 把线程放到集合中
                    ManageClientThreads.addClientThread(u.getUserId(),serverConnectClientThread);
                }else {
                    System.out.println("用户 id=" + u.getUserId() + " pwd =" + u.getPasswd() + " 验证失败");
                    // 登录失败
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    // 关闭 socket
                    socket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 如果服务端退出了 while 循环，不再监听，需要关闭 ServerSocket
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
