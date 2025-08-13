package service;

import dao.BillDao;
import dao.MultiTableDAO;
import domain.Bill;
import domain.DiningTable;
import domain.Menu;
import domain.MultiTableBean;
import utils.Utility;

import java.util.List;
import java.util.UUID;

/**
 * ClassName: BillService
 * Package: service
 * Description:
 *
 * @author jacksonling
 * @version 1.0
 * @Date 2025-08-07 19:56
 */
public class BillService {
    private BillDao billDao = new BillDao();

    // 调用 MenuService 类中的方法，传入 id，返回菜品对象，用于计算价格
    private MenuService menuService = new MenuService();

    // 点完餐后需要更新餐桌状态
    DiningTableService diningTableService = new DiningTableService();

    // 结合多表查询
    private MultiTableDAO multiTableDao = new MultiTableDAO();

    /**
     * 点餐功能
     * （1）生成账单
     * 参数：订单号、菜品编号、份数、金额、餐桌号、订单日期、订单状态（未结账、已经结账、挂单...）
     * 传入参数：菜品编号、份数、餐桌号（）
     * （2）更新餐桌状态（数据库）
     */
    public boolean orderMenu(int menuId, int nums, int diningTableId) {
        // 随机生成一个订单号
        String billId = UUID.randomUUID().toString();

        // 更新账单表，同时根据传入信息计算余额
        int update = billDao.update("insert into bill values(null,?,?,?,?,?,now(),'未结账')",
                billId, menuId, nums, menuService.getMenuById(menuId).getPrice() * nums, diningTableId);

        if (update <= 0) {
            return false;
        }

        //需要更新对应餐桌的状态
        return diningTableService.updateDiningTableState(diningTableId, "就餐中");

    }

    // 用户层点餐界面
    public void orderMenu() {
        System.out.println("==============点餐服务============");
        System.out.print("请输入点餐的桌号(-1退出): ");
        int orderDiningTableId = Utility.readInt();
        if (orderDiningTableId == -1) {
            System.out.println("==============取消点餐============");
            return;
        }
        System.out.print("请输入点餐的菜品号(-1退出): ");
        int orderMenuId = Utility.readInt();
        if (orderMenuId == -1) {
            System.out.println("==============取消点餐============");
            return;
        }
        System.out.print("请输入点餐的菜品量(-1退出): ");
        int orderNums = Utility.readInt();
        if (orderNums == -1) {
            System.out.println("==============取消点餐============");
            return;
        }

        //验证餐桌号是否存在
        DiningTable diningTable = diningTableService.getDiningTableById(orderDiningTableId);
        if (diningTable == null) {
            System.out.println("==============餐桌号不存在============");
            return;
        }
        //验证菜品编号
        Menu menu = menuService.getMenuById(orderMenuId);
        if (menu == null) {
            System.out.println("==============菜品号不存在============");
            return;
        }

        //点餐
        if (orderMenu(orderMenuId, orderNums, orderDiningTableId)) {
            System.out.println("==============点餐成功============");
        } else {
            System.out.println("==============点餐失败============");
        }

    }

    // 显示所有账单
    public void listBill() {
        List<Bill> bills = billDao.queryTable("select * from bill", Bill.class);
        System.out.println("\n编号\t菜品号\t\t菜品量\t\t金额\t\t桌号\t\t日期\t\t\t\t\t\t\t状态");
        for (Bill bill : bills) {
            System.out.println(bill);
        }
        System.out.println("==============显示完毕============");
    }

    // 显示所有账单，并带有菜品名价格
    public void listBill2() {
        List<MultiTableBean> multiTableBeans = multiTableDao.queryTable("SELECT bill.*, NAME, price " +
                "FROM bill, menu " +
                "WHERE bill.menuId = menu.id", MultiTableBean.class);
        System.out.println("\n编号\t菜品号\t\t菜品量\t\t金额\t\t桌号\t\t日期\t\t\t\t\t\t状态\t\t菜品名\t\t价格");
        for (MultiTableBean bill : multiTableBeans) {
            System.out.println(bill);
        }
        System.out.println("==============显示完毕============");
    }


    // 判断是否有未结账的账单
    public boolean hasPayBillByDiningTableId(int diningTableId) {
        Bill bill = billDao.queryLine("SELECT * FROM bill WHERE diningTableId=? AND state = '未结账' LIMIT 0, 1", Bill.class, diningTableId);
        return bill != null;
    }

    // 结账功能
    public boolean payBill(int diningTableId, String payMode) {

        //如果这里使用事务的话，需要用ThreadLocal来解决 , 框架中比如mybatis 提供了事务支持

        // 1. 更新 bill 表，记录支付方式
        int update = billDao.update("update bill set state=? where diningTableId=? and state='未结账'", payMode, diningTableId);
        if (update <= 0) { //如果更新没有成功，则表示失败...
            return false;
        }

        // 2. 修改 diningTable 表，更新状态，同时把订桌人相关信息滞空
        //注意：不要直接在这里操作，而应该调用DiningTableService 方法,完成更新，体现各司其职

        if (!diningTableService.updateDiningTableToFree(diningTableId, "空")) {
            return false;
        }
        return true;
    }

    // 用户层结账界面
    public void payBill() {
        System.out.println("==============结账服务============");
        System.out.print("请选择要结账的餐桌编号(-1退出): ");
        int diningTableId = Utility.readInt();
        if (diningTableId == -1) {
            System.out.println("=============取消结账============");
            return;
        }
        //验证餐桌是否存在
        DiningTable diningTable = diningTableService.getDiningTableById(diningTableId);
        if (diningTable == null) {
            System.out.println("=============结账的餐桌不存在============");
            return;
        }
        //验证餐桌是否有需要结账的账单
        if (!hasPayBillByDiningTableId(diningTableId)) {
            System.out.println("=============该餐位没有未结账账单============");
            return;
        }
        System.out.print("结账方式(现金/支付宝/微信)回车表示退出: ");
        String payMode = Utility.readString(20, ""); // 如果回车，就是返回 ""
        if ("".equals(payMode)) {
            System.out.println("=============取消结账============");
            return;
        }
        char key = Utility.readConfirmSelection();
        if (key == 'Y') { //结账

            //调用我们写的方法
            if (payBill(diningTableId, payMode)) {
                System.out.println("=============完成结账============");
            } else {
                System.out.println("=============结账失败============");
            }

        } else {
            System.out.println("=============取消结账============");
        }
    }

}
