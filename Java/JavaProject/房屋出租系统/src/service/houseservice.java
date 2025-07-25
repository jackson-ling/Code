package service;

import domain.House;

public class houseservice {
    /*
        信息： 编号，房主，电话，地址，月租，状态（未出租/已出租）
        House数组的说明：数组的每一个元素都存储house类的对象的各种属性
    */
    private House[] houses; // 初始化一个House对象的数组
    private int housenum = 1; // 记录目前房屋的信息数
    private int houseid = 1; // 记录房屋的编号


    // 构造器
    public houseservice(int size) {
        houses = new House[size];
        houses[0] = new House(1, "jack", "123123", "usa", 500, "未出租");
    }

    // 方法：返回房屋数组
    public House[] list() {
        return houses;
    }

    //添加房屋信息
    public boolean add(House newhouse) {
        //首先判断是否能继续添加
        if (housenum == houses.length) {
            System.out.println("房屋信息已经满了，无法继续添加！");
            return false;
        }
        // 添加信息
        houses[housenum] = newhouse;
        housenum++;
        //修改加入房屋的编号,自增一
        houseid++;
        newhouse.setId(houseid);
        return true;
    }

    //删除房屋信息
    public boolean del(int delid) {
        int index = -1; // 如果index的值没有改变，就代表需要删除的编号不存在

        //遍历house数组，判断是否有要删除的编号，执行删除操作
        for (int i = 0; i < housenum; i++) {
            if (delid == houses[i].getId()) {
                index = i; // 记录要删除房屋编号的数组下标
            }
        }
        // 房屋编号不存在
        if (index == -1) {
            return false;
        }

        //执行删除操作（采用顺序表的删除思想）
        for (int i = index; i < housenum - 1; i++) {
            houses[i] = houses[i + 1];  // 用后面的元素覆盖需要删除的元素
        }

        // 删除后需要修改房屋的数量，并把空位处的元素置空
        houses[housenum - 1] = null;
        housenum--;
        return true;
    }

    // 查找房屋信息
    public House findhouseid(int findid) {
        for (int i = 0; i < housenum; i++) {
            if (findid == houses[i].getId()) {
                return houses[i];
            }
        }

        // 遍历之后都没有找到，返回空
        return null;
    }
}
