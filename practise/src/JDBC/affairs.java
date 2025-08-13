/*
package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

*/
/**
 * ClassName: affairs
 * Package: JDBC
 * Description:
 *
 * @author jacksonling
 * @version 1.0
 * @Create 2025-07-29 17:07
 *//*

public class affairs {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        // 执行sql
        String sql_1 = "update account set balance = balance- 100 where id = 1";
        String sql_2 = "update account set balance = balance + 100 where id = 2";
        try {
            // 获取 connection，默认自动提交
            connection = JDBCUtils.getConnection();

            // 开启事务，设置为不自动提交
            connection.setAutoCommit(false);

            // 执行 sql_1
            preparedStatement = connection.prepareStatement(sql_1);
            preparedStatement.executeUpdate();

            // 执行 sql_2（此时 preparedStatement 改变指向）
            preparedStatement = connection.prepareStatement(sql_2);
            preparedStatement.executeUpdate();

            // 提交事务
            connection.commit();
        } catch (SQLException e) {
            System.out.println("执行发生了异常，撤销执行的sql");
            // 出现异常，事务回滚
            try {
                connection.rollback(); // 回滚到开启事务的状态
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // 关闭资源
            JDBCUtils.close(null,preparedStatement,connection);
        }
    }
}
*/
