package service;

import common.Message;
import common.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class MessageClientService {

    // 私聊功能，发送信息
    public void sendMessageToOne(String content,String senderId,String getterId){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COMM_MES); // 设置消息类型
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setContent(content);
        message.setSendTime(new Date().toString()); // 设置发送时间
        System.out.println(senderId + " 对 " + getterId + " 说：" + content);

        // 发送给服务端
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManagerClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 群发消息
    public void sendMessageToAll(String content,String senderId){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_TO_ALL_MES); // 设置消息类型
        message.setSender(senderId);
        message.setContent(content);
        message.setSendTime(new Date().toString()); // 设置发送时间
        System.out.println(senderId + " 对大家说：" + content);

        // 发送给服务端
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManagerClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
