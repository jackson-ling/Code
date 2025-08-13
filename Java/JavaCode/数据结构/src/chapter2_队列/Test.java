package chapter2_队列;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Test {
    public static void main(String[] args) {
        Queue circleQueue = new Queue(5);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        try {
            while (loop) {
                System.out.println("=====输入数字选择功能=====");
                System.out.println("1. 判断队空（isEmpty）");
                System.out.println("2. 判断队满（isFull）");
                System.out.println("3. 队列大小（size）");
                System.out.println("4. 获取队头元素（getHead()）");
                System.out.println("5. 入队（enQueue）");
                System.out.println("6. 出队（deQueue）");
                System.out.println("7. 打印队列（showQueue）");
                System.out.println("0. 退出");
                System.out.print("请输入你的选择（数字）：");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        if (circleQueue.isEmpty()) {
                            System.out.println("队列为空");
                        } else {
                            System.out.println("队列不为空");
                        }
                        break;
                    case 2:
                        if (circleQueue.isFull()) {
                            System.out.println("队列已满");
                        } else {
                            System.out.println("队列未满");
                        }
                        break;
                    case 3:
                        System.out.println("队列的大小：" + circleQueue.size());
                        break;
                    case 4:
                        try {
                            System.out.println("队头元素为：" + circleQueue.getHead());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            System.out.print("请输入队元素：");
                            int enQueueVal = scanner.nextInt();
                            circleQueue.enQueue(enQueueVal);
                            System.out.println("入队成功");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                            circleQueue.deQueue();
                            System.out.println("出队成功");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 7:
                        circleQueue.showQueue();
                        break;
                    case 0:
                        loop = false;
                        break;
                    default:
                        System.out.println("你的输入有误，请重新输入");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("输入无效，请输入数字");
            scanner.nextLine(); // 清空输入缓冲区
        }
        // 关闭资源
        scanner.close();
    }
}
