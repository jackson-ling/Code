import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class basic {
    public static void main(String[] args) {


        double money = 0; // 初始化零钱
        boolean loop = true;  // 用于记录是否退出循环
        String details = "---------------零钱通明细---------------";
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//日期的格式化

        while (loop) {
            // 每次循环提示菜单，提高用户使用的便捷性
            System.out.println();
            System.out.println("---------------零钱通菜单---------------");
            System.out.println("\t\t\t1.零钱通明细");
            System.out.println("\t\t\t2.收益入账");
            System.out.println("\t\t\t3.消费");
            System.out.println("\t\t\t4.退出");
            System.out.println("----------------------------------------");

            System.out.print("\n请选择功能：");
            Scanner input = new Scanner(System.in);
            //使用String类型是为了输入不合法字符时避免因类型不兼容报错，简化了处理步骤
            String choice = input.next();
            switch (choice) {

                case "1":
                    System.out.println(details);
                    break;

                case "2":
                    System.out.print("输入入账金额：");
                    double income = input.nextDouble();

                    if (income <= 0) {
                        System.out.println("入账金额需要大于0");
                        break;
                    }
                    money += income;

                    date = new Date();

                    details += "\n收益入账\t" + "+" + income + "\t" + sdf.format(date) + "\t" + "余额：" + money;
                    break;

                case "3":
                    if(money == 0){
                        System.out.println("你的钱花光了，请等待下一笔入账之后再消费~~");
                        break;
                    }

                    System.out.print("消费去向：");
                    String info = input.next();

                    System.out.print("消费金额：");
                    double span = input.nextDouble();

                    if (span < 0 || span > money) {
                        System.out.println("消费金额需要在 0 ~ " + money + "之间");
                        break;
                    }

                    money -= span;

                    date = new Date();

                    details += "\n" + info + "\t" + "-" + span + "\t" + sdf.format(date) + "\t" + "余额：" + money;
                    break;

                case "4":
                    String choice1 = "";  // 初始化位空字符，否则值为null
                    while (true) {
                        System.out.println("\n确认退出吗？y/n");
                        System.out.print("请输入选择：");
                        choice1 = input.next();
                        // 编程习惯；一段代码实现一个功能，分开写提高代码的可读性
                        // 1.首先判断输入的字符是否合理
                        if (choice1.equals("y") || choice1.equals("n")) {
                            break;
                        }
                    }

                    // 2. 在字符输入合理的前提下判断是否退出
                    if (choice1.equals("y")) {
                        loop = false;
                        System.out.println("------------退出了零钱通系统-------------");
                    }
                    break;

                default:
                    System.out.println("请输入（1 - 4） 选择功能");
                    break;
            }
        }
    }
}
