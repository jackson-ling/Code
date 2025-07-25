package service;

import common.Message;
import common.MessageType;
import utils.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class SendNewsToAllService implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("请输入服务器要推送的信息(输入exit退出)");
            String news = Utility.readString(100);

            if("exit".equals(news)){
                break;
            }
            // 服务器推送信息的本质就是群发
            Message message = new Message();
            message.setSender("服务器");
            message.setContent(news);
            message.setMesType(MessageType.MESSAGE_TO_ALL_MES);
            message.setSendTime(new Date().toString());
            System.out.println("服务器推送信息给所有人说：" + news);

            // 遍历集合，拿到 socket，发送信息
            HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();
            Iterator<String> iterator = hm.keySet().iterator();
            while (iterator.hasNext()){
                String onLineUserId = iterator.next().toString();
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(hm.get(onLineUserId).getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
