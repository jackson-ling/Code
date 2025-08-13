package JDBC;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: DBUtils
 * Package: JDBC
 * Description:
 *
 * @author jacksonling
 * @version 1.0
 * @Date 2025-08-01 16:19
 */
public class DBUtils {
    public static void main(String[] args) throws Exception {
        query();
    }

    public static void query() throws Exception {

        // 获取连接
        Connection connection = JDBCUtils_Druid.getConnection();
        // 获取 QueryRunner 对象，用它去调用相应的方法
        QueryRunner queryRunner = new QueryRunner();
        // 定义 sql 语句
        String sql = "insert into actor values (null,'john502','男')";
        // 调用查询方法
        int rows = queryRunner.update(connection,sql);
        // 判断是否执行
        if (rows > 0) {
            System.out.println("执行成功");
        } else {
            System.out.println("执行失败");
        }
        // 关闭资源
        JDBCUtils_Druid.close(null, connection, null);
    }
}
