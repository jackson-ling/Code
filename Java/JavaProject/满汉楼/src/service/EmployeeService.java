package service;

import dao.EmployeeDao;
import domain.Employee;

public class EmployeeService {

    //定义一个 EmployeeDAO 属性
    private EmployeeDao employeeDao = new EmployeeDao();

    /**
     * @param empId
     * @param pwd
     * @return Employee
     *
     * 登录验证功能，传入用户名，密码
     * 返回一个 Employee 对象，在主菜单中判断 Employee 是否为空进而判断是否登录成功
     */
    public Employee getEmployeeByIdAndPwd(String empId, String pwd) {
        return employeeDao.queryLine("select * from employee where empId=? and pwd=md5(?)", Employee.class, empId, pwd);
    }
}
