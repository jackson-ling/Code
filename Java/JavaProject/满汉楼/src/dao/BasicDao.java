package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JDBCUtils_Druid;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * ClassName: basicdao
 * Package: dao
 * Description:
 *
 * @author jacksonling
 * @version 1.0
 * @Date 2025-08-05 19:35
 */
public class BasicDao<T> {
    // 使用 DBUtils 封装DAO类，实现对数据库的增删改查

    // 创建 queryRunner 对象
    QueryRunner queryRunner = new QueryRunner();

    // 查询全表
    public List<T> queryTable(String sql, Class<T> clazz, Object... parameters) {
        Connection connection = null;
        try {
            // 获取连接
            connection = JDBCUtils_Druid.getConnection();
            // 返回查询结果
            return queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            JDBCUtils_Druid.close(null, connection, null);
        }
    }

    // 单行查询
    public T queryLine(String sql, Class<T> clazz, Object... parameters) {
        Connection connection = null;
        try {
            // 获取连接
            connection = JDBCUtils_Druid.getConnection();
            // 返回查询结果
            return queryRunner.query(connection, sql, new BeanHandler<T>(clazz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            JDBCUtils_Druid.close(null, connection, null);
        }
    }

    // 单行单列查询
    public Object queryValue(String sql, Object... parameters) {
        Connection connection = null;
        try {
            // 获取连接
            connection = JDBCUtils_Druid.getConnection();
            // 返回查询结果
            return queryRunner.query(connection, sql, new ScalarHandler(), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            JDBCUtils_Druid.close(null, connection, null);
        }
    }

    // DML语句
    public int update(String sql, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtils_Druid.getConnection();
            int rows = queryRunner.update(connection, sql, parameters);
            return rows;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid.close(null, connection, null);
        }
    }
}
