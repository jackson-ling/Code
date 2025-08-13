package JDBC;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Properties;

/**
 * ClassName: 连接池
 * Package: JDBC
 * Description:
 *
 * @author jacksonling
 * @version 1.0
 * @Date 2025-07-31 15:30
 */
public class c3p0 {
    public static void main(String[] args) throws Exception {
        Xml_Connection();
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
    }
    public static void connection() throws Exception {
        // 创建数据源对象（连接池）
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        // 获取配置信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/JDBC/connect.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        // 设置数据源的相关参数
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setDriverClass(driver);

        // 初始化连接数
        comboPooledDataSource.setInitialPoolSize(5);
        // 最大连接数
        comboPooledDataSource.setMaxPoolSize(10);

        // 测试连接速度
        long start = System.currentTimeMillis();
        for (int i = 0; i < 999999; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时：" + (end - start));
    }

    public static void Xml_Connection() throws Exception{
        // 使用配置文件模板
        ComboPooledDataSource connectionPool = new ComboPooledDataSource("connectionPool");
        // 测试连接速度
        long start = System.currentTimeMillis();
        for (int i = 0; i < 999999; i++) {
            Connection connection = connectionPool.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时：" + (end - start));
    }
}
