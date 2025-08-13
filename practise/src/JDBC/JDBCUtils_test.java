package JDBC;

import java.sql.*;
import java.util.ArrayList;

/**
 * ClassName: JDBCUtils_test
 * Package: JDBC
 * Description:
 *
 * @author jacksonling
 * @version 1.0
 * @Create 2025-07-29 16:23
 */
public class JDBCUtils_test {
    public static void main(String[] args) {
        // 定义变量
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        // sql 语句
        String sql = "insert into actor values (null,?,'男')";
        try {
            // 获取连接
            connection = JDBCUtils_Druid.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            System.out.println("开始执行...");
            for (int i = 0; i < 500; i++) {
                preparedStatement.setString(1, "john" + (i + 1));
                // 添加到批处理包中
                preparedStatement.addBatch();
                // 自定义处理的批处理的记录数（下方单次处理 100 条记录）
                if ((i + 1) % 100 == 0) {
                    // 批量执行
                    preparedStatement.executeBatch();
                    // 清空批处理包
                    preparedStatement.clearBatch();
                }
            }
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("执行成功");
            } else {
                System.out.println("执行失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid.close(resultSet, connection, preparedStatement);
        }
    }
}

