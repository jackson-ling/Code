package DAO.utils;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils_Druid {
    private static DataSource dataSource;

    // 静态代码块，完成初始化工作
    static {
        Properties properties = properties = new Properties();
        try {
            properties.load(new FileInputStream("src/druid.properties"));
            // 调用方法读取信息
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 获取连接
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // 关闭连接
    // 关闭连接（注意：这里不是真的断掉连接，只是把使用的Connection对象放回连接池）
    public static void close(ResultSet resultSet, Connection connection, Statement statement){
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
