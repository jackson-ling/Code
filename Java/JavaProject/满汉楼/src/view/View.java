package view;

import domain.Employee;
import service.BillService;
import service.DiningTableService;
import service.EmployeeService;
import service.MenuService;
import utils.Utility;

/**
 * ClassName: logInView
 * Package: view
 * Description:
 *
 * @author jacksonling
 * @version 1.0
 * @Date 2025-08-06 14:09
 */

public class View {
    // 循环结束标志
    boolean loop = true;
    // 接收用户输入
    String key = "";

    // 创建 EmployeeService 对象
    EmployeeService employeeService = new EmployeeService();
    // 创建 DiningTableService 对象
    DiningTableService diningTableService = new DiningTableService();
    // 创建 MenuService 对象
    MenuService menuService = new MenuService();
    // 创建 BillService 对象
    BillService billService = new BillService();

    //显示主菜单
    public void mainMenu() {
        while (loop) {
            System.out.println("\n===============满汉楼================");
            System.out.println("\t\t 1 登录满汉楼");
            System.out.println("\t\t 2 退出满汉楼");
            System.out.print("请输入你的选择: ");
            key = Utility.readString(1);
            switch (key) {
                case "1":
                    System.out.print("输入员工号: ");
                    String empId = Utility.readString(50);
                    System.out.print("输入密  码: ");
                    String pwd = Utility.readString(50);
                    Employee employee = employeeService.getEmployeeByIdAndPwd(empId, pwd);
                    if (employee != null) { //说明存在该用户
                        System.out.println("===============登录成功[" + employee.getName() + "]================\n");
                        //显示二级菜单, 这里二级菜单是循环操作，所以做成while
                        while (loop) {
                            System.out.println("\n===============满汉楼(二级菜单)================");
                            System.out.println("\t\t 1 显示餐桌状态");
                            System.out.println("\t\t 2 预定餐桌");
                            System.out.println("\t\t 3 显示所有菜品");
                            System.out.println("\t\t 4 点餐服务");
                            System.out.println("\t\t 5 查看账单");
                            System.out.println("\t\t 6 结账");
                            System.out.println("\t\t 9 退出满汉楼");
                            System.out.print("请输入你的选择: ");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    // 显示餐桌状态
                                    diningTableService.listDiningTale();
                                    break;
                                case "2":
                                    // 预定餐桌
                                    diningTableService.orderDiningTable();
                                    break;
                                case "3":
                                    // 显示所有菜品
                                    menuService.listMenu();
                                    break;
                                case "4":
                                    // 点餐服务
                                    billService.orderMenu();
                                    break;
                                case "5":
                                    // 查看账单
                                    /*billService.listBill();*/
                                    billService.listBill2();
                                    break;
                                case "6":
                                    // 结账
                                    billService.payBill();
                                    break;
                                case "9":
                                    loop = false;
                                    break;
                                default:
                                    System.out.println("你的输入有误，请重新输入");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("=====登录失败（用户名 / 密码错误）=====");
                    }
                    break;
                case "2":
                    loop = false;
                    break;
                default:
                    System.out.println("你输入有误，请重新输入.");
            }
        }
        System.out.println("退出了满汉楼系统~");

    }
}
