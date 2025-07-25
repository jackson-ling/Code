package service;

import common.Message;
import common.MessageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

public class ServerConnectClientThread extends Thread {

    private Socket socket;
    private String userId; // 连接服务端的用户 id

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() { // 线程，可以给客户端发送信息或者接收客户端的信息
        while (true) {
            System.out.println("服务端和客户端" + userId + "保持通信，读取数据中...");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();

                // 接收用户端发送的信息，做相应的处理
                if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    System.out.println(message.getSender() + " 要在线用户列表");
                    // 通过方法获取到在线用户列表
                    String onlineUser = ManageClientThreads.getOnlineUser();
                    // 构建 message 对象，准备回复消息给客户端
                    Message message2 = new Message();
                    // 一定要注意类类型，否则用户端接收的信息类型是错的，业务逻辑就会出现错误
                    message2.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message2.setContent(onlineUser); // 放入在线用户信息
                    message2.setGetter(message.getSender());
                    // 把信息发送给客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message2);

                } else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)){
                    System.out.println(message.getSender() + " 退出");
                    // 将线程从集合中移除
                    ManageClientThreads.removeServerConnectClientThread(message.getSender());
                    socket.close(); // 关闭连接
                    break; // 退出线程
                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)){
                    // 根据 message 获取 userId
                    ServerConnectClientThread serverConnectClientThread = ManageClientThreads.getServerConnectClientThread(message.getGetter());
                    // 得到 socket 输出流，转发信息
                    ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message); // 转发信息
                }else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)){
                    // 群发消息：遍历集合，把所有线程的socket都得到，转发message即可
                    HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();
                    Iterator<String> iterator = hm.keySet().iterator();
                    while (iterator.hasNext()){
                        String onLineUserId = iterator.next().toString();
                        // 排除群发消息的用户
                        if(!onLineUserId.equals(message.getSender())){
                            ObjectOutputStream oos = new ObjectOutputStream(hm.get(onLineUserId).getSocket().getOutputStream());
                            oos.writeObject(message);
                        }
                    }
                }else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)){
                    // 转发文件消息
                    ObjectOutputStream oos = new ObjectOutputStream(ManageClientThreads.getServerConnectClientThread(message.getGetter()).getSocket().getOutputStream());
                    oos.writeObject(message);
                }
                else {
                    System.out.println("其他类型的message，暂时不处理");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
