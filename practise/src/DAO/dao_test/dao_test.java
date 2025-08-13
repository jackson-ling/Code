package DAO.dao_test;

import DAO.dao.actordao;
import DAO.domain.Actor;

import java.util.List;

public class dao_test {
    public static void main(String[] args) {
        // 创建表的domain对象（dao）
        actordao actordao = new actordao();

        // 调方法完成 CRUD 操作

        // 查询全表
        List<Actor> list = actordao.queryTable("select * from actor", Actor.class);
        for (Actor actor : list) {
            System.out.println(actor);
        }

        // 单行查询
        Actor actor = actordao.queryLine("select * from actor where id=?", Actor.class, 6);
        System.out.println(actor);

        // 单行单列查询
        Object o = actordao.queryValue("select name from actor where id = ?", Actor.class, 6);
        System.out.println(o);

        // DML 语句
        int update = actordao.update("insert into actor values(?,?,?)", null, "john506", "男");
        System.out.println(update > 0 ? "执行成功" : "执行失败");
    }
}
