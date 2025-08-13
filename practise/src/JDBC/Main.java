package JDBC;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 * ClassName: ${NAME}
 * Package:
 * Description:
 *
 * @author jacksonling
 * @version 1.0
 * @Date ${DATE} ${TIME}
 */
public class Main {
    public static void main(String[] args) throws Exception {
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
        // sql 语句
        String sql = "insert into actor values (null,?,?)"; // 添加

/*
        // 修改
        String sql = "update actor set name = ? where name = ?";

        // 删除
        String sql = "delete from actor where name= ?";
*/

        // 获取 Statement 对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 利用set方法给 ? 占位赋值
        preparedStatement.setString(1, "fancy"); // 第一个问号
        preparedStatement.setString(2, "女"); // 第二个问号
        // 调用方法执行 sql 语句（注意，这里不要传入 sql，已经通过prepareStatement的一系列set方法设置了参数）
        int rows = preparedStatement.executeUpdate();
        // 判断是否成功
        if (rows > 0) {
            System.out.println("执行成功");
        } else {
            System.out.println("执行失败");
        }
        // 关闭资源
        preparedStatement.close();
        connection.close();
    }
}