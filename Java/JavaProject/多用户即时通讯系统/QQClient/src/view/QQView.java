package view;

import service.FileClientService;
import service.MessageClientService;
import service.UserClientService;
import utils.Utility;

public class QQView {
    private boolean loop = true;
    private String key = "";
    // 用于登录和注册用户
    private UserClientService userClientService = new UserClientService();
    // 私聊
    private MessageClientService messageClientService = new MessageClientService();
    // 发送文件
    private FileClientService fileClientService = new FileClientService();

    public static void main(String[] args) {
        new QQView().mainMenu();
    }
    // 显示主菜单
    private void mainMenu(){
        while (loop){
            System.out.println("===========欢迎登录网络通信系统===========");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.print("请输入你的选择: ");
            key = Utility.readString(1);

            switch (key) {
                case "1":
                    System.out.print("请输入用户号: ");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密  码: ");
                    String pwd = Utility.readString(50);
                    // 需要在服务端验证是否登录成功，并在用户端返回
                    if (userClientService.checkUser(userId,pwd)) {
                        System.out.println("===========欢迎 (用户 " + userId + " 登录成功) ===========");
                        //进入到二级菜单
                        while (loop) {
                            System.out.println("\n=========网络通信系统二级菜单(用户 " + userId + " )=======");
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 9 退出系统");
                            System.out.print("请输入你的选择: ");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    // 给服务端发送拉取在线用户请求，通过线程接收返回的信息
                                    userClientService.onlineFriend();
                                    break;
                                case "2":
                                    System.out.println("请输入想对大家说的话：");
                                    String s = Utility.readString(100);
                                    messageClientService.sendMessageToAll(s,userId);
                                    break;
                                case "3":
                                    System.out.print("请输入想聊天的用户号（在线）：");
                                    String getterId = Utility.readString(50);
                                    System.out.print("请输入想说的话：");
                                    String content = Utility.readString(100);
                                    // 调用方法，把信息发送给服务器，服务器转发信息
                                    messageClientService.sendMessageToOne(content,userId,getterId);
                                    break;
                                case "4":
                                    System.out.print("请输入你想把文件发送给的用户(在线用户): ");
                                    getterId = Utility.readString(50);
                                    System.out.print("请输入发送文件的路径(形式 d:\\xx.jpg)");
                                    String src = Utility.readString(100);
                                    System.out.print("请输入把文件发送到对应的路径(形式 d:\\yy.jpg)");
                                    String dest = Utility.readString(100);
                                    fileClientService.sendFileToOne(src,dest,userId,getterId);
                                    break;
                                case "9":
                                    //调用方法，给服务器发送一个退出系统的message
                                    userClientService.logout();
                                    loop = false;
                                    break;
                            }

                        }
                    } else { //登录服务器失败
                        System.out.println("=========登录失败=========");
                    }
                    break;
                case "9":
                    System.out.println("退出系统...");
                    loop = false;
                    break;
            }
        }
    }
}
