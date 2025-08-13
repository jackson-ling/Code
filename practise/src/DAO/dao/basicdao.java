package DAO.dao;

import JDBC.JDBCUtils_Druid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

// 使用泛型，指定接收某个类
public class basicdao<T> {
    // 使用 DBUtils，首先需要创建 QueryRunner对象
    QueryRunner queryRunner = new QueryRunner();

    // 查询全表
    public List<T> queryTable(String sql, Class<T> clazz,Object...parameters){
        Connection connection = null;
        try {
            // 获取连接
           connection = JDBCUtils_Druid.getConnection();
            // 返回结果
            return queryRunner.query(connection,sql,new BeanListHandler<T>(clazz),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils_Druid.close(null,connection,null);
        }
    }

    // 单行查询
    public T queryLine(String sql,Class<T> clazz,Object...parameters){
        Connection connection = null;
        try {
            // 获取连接
            connection = JDBCUtils_Druid.getConnection();
            // 返回结果
            return queryRunner.query(connection,sql,new BeanHandler<T>(clazz),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid.close(null,connection,null);
        }
    }

    // 单行单列查询
    public Object queryValue(String sql,Class<T> clazz,Object...parameters){
        Connection connection = null;
        try {
            // 获取连接
            connection = JDBCUtils_Druid.getConnection();
            // 返回结果
            return queryRunner.query(connection,sql,new ScalarHandler(),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid.close(null,connection,null);
        }
    }

    // DML语句（返回的是影响的行数）
    public int update(String sql,Object...parameters){
        Connection connection = null;
        try {
            // 获取连接
            connection = JDBCUtils_Druid.getConnection();
            // 返回结果
            int rows = queryRunner.update(connection,sql,parameters);
            return rows;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid.close(null,connection,null);
        }
    }

}
