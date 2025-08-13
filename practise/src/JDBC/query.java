package JDBC;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * ClassName: query
 * Package: JDBC
 * Description:
 *
 * @author jacksonling
 * @version 1.0
 * @Create 2025-07-28 21:43
 */
public class query {

    public static void main(String[] args) throws Exception {
        // 利用 properties 读取配置文件信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/JDBC/connect.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        // 注册驱动
        Class<?> aClass = Class.forName(driver);
        // 获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        // 得到Statement
        Statement statement = connection.createStatement();
        // 执行 sql 语句
        String sql = "select id, name,sex from actor";
        // 获取 resultSet（结果集）
        ResultSet resultSet = statement.executeQuery(sql);
        // 使用while循环读取数据
        while (resultSet.next()) {
            // 获取每一列数据
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String sex = resultSet.getString(3);
            // 打印信息
            System.out.println(id + "\t" + name + "\t" + sex);
        }

        // 关闭连接
        resultSet.close();
        statement.close();
        connection.close();

    }
}
