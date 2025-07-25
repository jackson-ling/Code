package view;

import domain.House;
import service.houseservice;
import utils.Utility;

public class Houseview {

    private boolean loop = true;

    public void housemenu() {

        while (loop) {

            System.out.println("------------房屋出租系统------------");
            System.out.println("\t\t\t1.新增房屋");
            System.out.println("\t\t\t2.查找房屋");
            System.out.println("\t\t\t3.删除房屋信息");
            System.out.println("\t\t\t4.修改房屋信息");
            System.out.println("\t\t\t5.房屋列表");
            System.out.println("\t\t\t6.退出");
            System.out.print("请输入数字（1--6）选择功能：");

            //如果方法是静态的(static),可以直接通过类名调用方法，无需创建对象
            char choice = Utility.readChar();

            switch (choice) {
                case '1':
                    addhouse();
                    break;
                case '2':
                    find();
                    break;
                case '3':
                    delhouse();
                    break;
                case '4':
                    this.update();
                    break;
                case '5':
                    houselist();
                    break;
                case '6':
                    exit();
                    break;
            }
        }
    }

    // 创建房屋数组这个对象，对数组的大小进行初始化，存储房屋信息
    private houseservice houseservice = new houseservice(2);

    public void houselist() {
        System.out.println("--------------房屋列表--------------");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态（未出租/已出租）");
        // 信息从数组层中调用，用一个数组接收在类方法中已经初始化的数组
        House[] house_arr = houseservice.list();
        for (int i = 0; i < house_arr.length; i++) {
            if (house_arr[i] == null) {
                break;
            }
            System.out.println(house_arr[i]);  // 在House类中重写了toString方法，这里会输出属性
        }
        System.out.println("---------房屋信息显示完毕---------\n");
    }

    // 方法：房屋的添加，在主界面中显示相关内容，并调用add（）方法进行添加
    public void addhouse() {

        // 内容提示和用户输入
        System.out.println("------------房屋信息添加------------");
        System.out.print("姓名: ");
        String name = Utility.readString(8);
        System.out.print("电话: ");
        String phone = Utility.readString(12);
        System.out.print("地址: ");
        String address = Utility.readString(16);
        System.out.print("月租: ");
        int rent = Utility.readInt();
        System.out.print("状态: ");
        String state = Utility.readString(3);

        // 创建对象，把值传入进去形成一个house对象类型的数组元素
        House newhouse = new House(0, name, phone, address, rent, state);
        houseservice.add(newhouse);

        System.out.println("-----------房屋信息添加成功----------\n");
    }

    // 方法：删除房屋信息
    public void delhouse() {
        System.out.println("------------房屋信息添加------------");
        System.out.print("请输入待删除房屋的编号(-1退出):");
        int delid = Utility.readInt();
        if (delid == -1) {
            System.out.println("---------退出了删除房屋信息---------");
            return;
        }
        //注意该方法本身就有循环判断的逻辑,必须输出Y/N
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {//真的删除
            //判断房屋编号是否存在
            if (houseservice.del(delid)) {
                System.out.println("=============删除房屋信息成功============");
            } else {
                System.out.println("=============房屋编号不存在，删除失败============");
            }
        } else {
            System.out.println("=============放弃删除房屋信息============");
        }
    }

    // 退出确认
    public void exit() {
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        }
        System.out.println("-------退出了房屋出租系统------");
    }

    // 查找房屋信息
    public void find() {
        System.out.println("---------房屋id查询界面---------");
        System.out.print("请输出你要查询的房屋id：");
        int findid = Utility.readInt();
        // 通过id返回的是house数组的全部信息，用house对象接收
        House findhouse = houseservice.findhouseid(findid);
        if (findhouse != null) {
            // 通过重写toString，在输出对象时会直接输出对象的属性
            System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态（未出租/已出租）");
            System.out.println(findhouse);
        } else {
            System.out.println("---------查找的房屋id不存在---------\n");
        }
    }
    //根据id修改房屋信息
    public void update() {
        System.out.println("=============修改房屋信息============");
        System.out.println("请选择待修改房屋编号(-1表示退出)");
        int updateId = Utility.readInt();
        if (updateId == -1) {
            System.out.println("=============你放弃修改房屋信息============");
            return;
        }

        //根据输入得到updateId，查找对象

        // 返回的是数组（引用类型），对齐内容修改会直接影响数组本身的内容
        House house = houseservice.findhouseid(updateId);
        if (house == null) {
            System.out.println("=============修改房屋信息编号不存在..============");
            return;
        }

        System.out.print("姓名(" + house.getName() + "): ");
        String name = Utility.readString(8, "");//这里如果用户直接回车表示不修改该信息,默认""
        if (!"".equals(name)) {//修改
            house.setName(name);
        }

        System.out.print("电话(" + house.getPhone() + "):");
        String phone = Utility.readString(12, "");
        if (!"".equals(phone)) {
            house.setPhone(phone);
        }
        System.out.print("地址(" + house.getAddress() + "): ");
        String address = Utility.readString(18, "");
        if (!"".equals(address)) {
            house.setAddress(address);
        }
        System.out.print("租金(" + house.getRent() + "):");
        int rent = Utility.readInt(-1);
        if (rent != -1) {
            house.setRent(rent);
        }
        System.out.print("状态(" + house.getState() + "):");
        String state = Utility.readString(3, "");
        if (!"".equals(state)) {
            house.setState(state);
        }
        System.out.println("=============修改房屋信息成功============");
    }
}

