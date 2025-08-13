package practise;

import java.util.ArrayList;
import java.util.stream.Stream;

public class pra {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("jack", 18));
        employees.add(new Employee("tom", 23));
        employees.add(new Employee("lucy", 25));
        employees.add(new Employee("bob", 26));
        employees.add(new Employee("jack", 18));
        employees.add(new Employee("jack", 18));

        // 过滤
        Stream<Employee> stream1 = employees.stream();
        System.out.println("执行过滤：打印年龄大于 20 岁的员工");
        stream1.filter(employee -> employee.getAge() > 20).forEach(System.out::println);

        System.out.println();

        // 去重
        Stream<Employee> stream2 = employees.stream();
        System.out.println("执行去重");
        stream2.distinct().forEach(System.out::println);

        System.out.println();

        // 只查看前两名员工信息
        System.out.println("只查看前两名员工信息");
        employees.stream().limit(2).forEach(System.out::println);

        System.out.println();

        // 跳过前两名员工的信息
        System.out.println("跳过前两名员工的信息");
        employees.stream().distinct().skip(2).forEach(System.out::println);
    }
}

class Employee {
    String name;
    int age;

    public Employee() {

    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;  // 如果是同一个对象，直接返回 true
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;  // 如果类型不同，返回 false
        }

        Employee employee = (Employee) obj;  // 将 obj 转换为 Employee
        return age == employee.age && name.equals(employee.name);  // 比较 name 和 age
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + age;  // 使用 name 和 age 来计算哈希值
    }
}