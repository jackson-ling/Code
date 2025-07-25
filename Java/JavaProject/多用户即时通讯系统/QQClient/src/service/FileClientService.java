package service;

import common.Message;
import common.MessageType;

import java.io.*;

public class FileClientService {
    public void sendFileToOne(String src,String dest,String senderId,String getterId){
        // 读取 src 文件，封装到 message 中
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_FILE_MES);
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setSrc(src);
        message.setDest(dest);

        // 文件读取
        FileInputStream fileInputStream = null;
        byte[] fileBytes = new byte[(int)new File(src).length()];
        try {
            fileInputStream = new FileInputStream(src);
            fileInputStream.read(fileBytes);
            // 封装到 message 对象中
            message.setFileBytes(fileBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // 提示信息
        System.out.println("\n" + senderId + "给" + getterId + "发送文件：" + src + " 到对方的电脑目录" + dest);

        // 发送文件到服务端
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManagerClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
