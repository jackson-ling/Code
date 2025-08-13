package utils;

import dao.EmployeeDao;
import domain.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * ClassName: test
 * Package: utils
 * Description:
 *
 * @author jacksonling
 * @version 1.0
 * @Date 2025-08-05 20:40
 */
public class test {
    public static void main(String[] args) throws SQLException {
        // 测试连接
        Connection connection = JDBCUtils_Druid.getConnection();
        System.out.println(connection);
        // DQL语句测试
        EmployeeDao employeeDao = new EmployeeDao();
        String sql = "select * from employee";
        List<Employee> employees = employeeDao.queryTable(sql, Employee.class);
        for (Employee employee :employees) {
            System.out.println(employee.getEmpId() + "\t" + employee.getName() + "\t" + employee.getJob()
            + "\t" + employee.getPwd());
        }
    }
}
