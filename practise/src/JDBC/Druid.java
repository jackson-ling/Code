package JDBC;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * ClassName: Duid
 * Package: JDBC
 * Description:
 *
 * @author jacksonling
 * @version 1.0
 * @Date 2025-07-31 16:44
 */
public class Druid {
    public static void main(String[] args) throws Exception {
        connection();
    }
    public static void connection() throws Exception{
        // 读取配置文件信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/JDBC/connect.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        // 测试连接速度
        long start = System.currentTimeMillis();
        for (int i = 0; i < 999999; i++) {
            Connection connection = dataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时：" + (end - start));
    }
}
