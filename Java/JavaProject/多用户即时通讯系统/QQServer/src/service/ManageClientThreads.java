package service;

import java.util.HashMap;
import java.util.Iterator;

public class ManageClientThreads {

    private static HashMap<String,ServerConnectClientThread> hm = new HashMap<>();

    // 返回 hashmap
    public static HashMap<String,ServerConnectClientThread> getHm() {
        return hm;
    }
    // 添加线程对象到 hm 集合中，key：userId ，value：线程
    public static void addClientThread(String userId, ServerConnectClientThread serverConnectClientThread){
        hm.put(userId,serverConnectClientThread);
    }

    // 根据 userId 返回线程
    public static ServerConnectClientThread getServerConnectClientThread(String userId){
        return hm.get(userId);
    }

    // 用户退出，线程结束，把线程从集合中取出
    public static void removeServerConnectClientThread(String userId){
        hm.remove(userId);
    }

    // 返回在新用户列表
    public static String getOnlineUser(){
        // 遍历 hashmap
        Iterator<String> iterator = hm.keySet().iterator();
        String onlineUserList = "";
        while(iterator.hasNext()){
            onlineUserList += iterator.next().toString() + " ";
        }
        return onlineUserList;
    }


}
