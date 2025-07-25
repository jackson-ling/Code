package service;

import java.util.HashMap;

public class ManagerClientConnectServerThread {
    // 把多线程放到 hashmap 集合中管理，key：用户id，value：线程
    private static HashMap<String,ClientConnectServerThread> hm = new HashMap<>();

    // 把线程加入集合
    public static  void addClientConnectSercerThread(String userId,ClientConnectServerThread clientConnectServerThread){
        hm.put(userId,clientConnectServerThread);
    }

    // 通过 userId 获取线程
    public static ClientConnectServerThread getClientConnectServerThread(String userId){
        return hm.get(userId);
    }
}
