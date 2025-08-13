package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * ClassName: JDBCUtils_Druid
 * Package: utils
 * Description:
 *
 * @author jacksonling
 * @version 1.0
 * @Date 2025-08-05 19:33
 */

public class JDBCUtils_Druid { // Druid 连接池
    private static DataSource dataSource = null;

    // 静态代码快初始化，读取配置文件信息
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 连接方法
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // 关闭资源
    public static void close(ResultSet resultSet,Connection connection,Statement statement){
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            /*
                实际开发中常用下面的方式处理
                1. 将编译异常转为运行异常
                2. 调用者可以选择捕获该异常，也可以选择默认处理该异常，比较方便
             */
            throw new RuntimeException(e);
        }
    }
}
