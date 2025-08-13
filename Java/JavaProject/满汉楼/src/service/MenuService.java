package service;

import dao.MenuDao;
import domain.Menu;

import java.util.List;

/**
 * ClassName: MenuService
 * Package: service
 * Description:
 *
 * @author jacksonling
 * @version 1.0
 * @Date 2025-08-06 18:35
 */
public class MenuService {

    //定义MenuDAO 属性
    private MenuDao menuDao = new MenuDao();

    //返回所有的菜品，在界面层调用
    public void listMenu(){
        List<Menu> menus = menuDao.queryTable("select * from menu", Menu.class);
        System.out.println("\n菜品编号\t\t菜品名\t\t类别\t\t价格");
        for (Menu menu : menus) {
            System.out.println(menu);
        }
        System.out.println("==============显示完毕============");
    }

    // 被 BillService 调用，用于返回菜品对象，计算价格
    public Menu getMenuById(int id) {
        return menuDao.queryLine("select * from menu where id = ?", Menu.class, id);
    }
}
