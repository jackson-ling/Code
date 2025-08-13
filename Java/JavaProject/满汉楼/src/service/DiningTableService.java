package service;

import dao.DiningTableDao;
import domain.DiningTable;
import utils.Utility;

import java.util.List;

/**
 * ClassName: DiningTableService
 * Package: service
 * Description:
 *
 * @author jacksonling
 * @version 1.0
 * @Date 2025-08-06 16:21
 */
public class DiningTableService {
    // 创建 Dao 对象
    private DiningTableDao diningTableDao = new DiningTableDao();

    // 编写方法，返回所有餐桌状态并显示
    public void listDiningTale(){
        List<DiningTable> diningTables = diningTableDao.queryTable("select id, state from diningTable", DiningTable.class);
        System.out.println("\n餐桌编号\t\t餐桌状态");
        for (DiningTable diningTable : diningTables) {
            System.out.println(diningTable);
        }
        System.out.println("==============显示完毕============");
    }

    /*
         餐桌预定的前提条件
        （1）预定的餐桌编号存在
        （2）餐桌状态为空
     */
    // 接收用户输入，根据 id 返回 DiningTable 对象，在界面层判断是否为空进而判断餐桌是否存在
    public DiningTable getDiningTableById(int id){
        return diningTableDao.queryLine("select * from diningTable where id = ?", DiningTable.class, id);
    }

    // 如果餐桌可以预定，接收预定信息，更新餐桌状态，返回 boolean，用于判断是否预定成功
    public boolean orderDiningTable(int id, String orderName, String orderTel) {
        // 返回影响的行数
        int update = diningTableDao.update("update diningTable set state='已经预定', orderName=?, orderTel=? where id=?", orderName, orderTel, id);
        return  update > 0;
    }

    // 餐桌预定功能
    public void orderDiningTable(){
        System.out.println("==============预定餐桌============");
        System.out.print("请选择要预定的餐桌编号(-1退出): ");
        int orderId = Utility.readInt();
        if (orderId == -1) {
            System.out.println("==============取消预订餐桌============");
            return;
        }
        //该方法得到的是 Y 或者 N
        char key = Utility.readConfirmSelection();
        if (key == 'Y') {//要预定

            // 判断预定的餐桌是否存在
            DiningTable diningTable = getDiningTableById(orderId);
            if (diningTable == null) {
                System.out.println("==============预订餐桌不存在============");
                return;
            }
            // 判断餐桌的状态是否 "空"
            if (!("空".equals(diningTable.getState()))) {//说明当前这个餐桌不是 "空" 状态
                System.out.println("==============该餐桌已经预定或者就餐中============");
                return;
            }

            //接收预定信息
            System.out.print("预定人的名字: ");
            String orderName = Utility.readString(50);
            System.out.print("预定人的电话: ");
            String orderTel = Utility.readString(50);

            //更新餐桌状态
            if (orderDiningTable(orderId, orderName, orderTel)) {
                System.out.println("==============预订餐桌成功============");
            } else {
                System.out.println("==============预订餐桌失败============");
            }

        } else {
            System.out.println("==============取消预订餐桌============");
        }
    }

    // 在点餐完成后，需要更新餐桌状态
    public boolean updateDiningTableState(int id, String state) {

        int update = diningTableDao.update("update diningTable set state=? where id=?", state, id);
        return update > 0;
    }

    // 客户结账，更新餐桌状态为空，清空餐桌预定人的相关信息
    public boolean updateDiningTableToFree(int id, String state) {
        int update = diningTableDao.update("update diningTable set state=?,orderName='',orderTel='' where id=?", state, id);
        return update > 0;
    }
}
