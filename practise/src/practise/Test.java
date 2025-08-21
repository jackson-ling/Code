package practise;

public class Test {
    public static void main(String[] args) {
        new b();
    }
}

class a{
    static {
        System.out.println("调用 父类 的 static 代码块");
        System.out.println();
        System.out.println("在 父类 的 static 代码块中调用 静态的 test() 方法");
        test();
        System.out.println("------------------------------------------");
    }

    {
        System.out.println("========类加载完毕，静态相关内容初始化结束，进入 构造器 的初始化！！！========\n");
        System.out.println("------------------------------------------");
        System.out.println("调用 父类 的 普通 代码块");
        System.out.println();
        System.out.println("在 父类 的 普通 代码块中调用 静态的 test() 方法");
        test();
        System.out.println();
        System.out.println("在 父类 的 普通 代码块中调用 静态的 test() 方法");
        test1();
        System.out.println("------------------------------------------");
    }

    public a(){
        System.out.println("调用 父类 的构造器");
        System.out.println("------------------------------------------" + "\n");
        System.out.println("===========该类的所有初始化工作结束，接着完成子类的初始化工作===========\n");
    }

    public static void test(){
        System.out.println("父类中 static 类型的 test() 方法被调用");
    }

    public void test1(){
        System.out.println("父类中 static 类型的 test1() 方法被调用");
    }

}

class b extends a{
    static {
        System.out.println("调用 子类 的 static 代码块");
        System.out.println();
        System.out.println("在 子类 的 static 代码块中调用 静态的 test() 方法");
        test();
        System.out.println("------------------------------------------" + "\n");
    }

    {
        System.out.println("------------------------------------------");
        System.out.println("调用 子类 的 普通 代码块");
        System.out.println();
        System.out.println("在 子类 的 普通 代码块中调用 静态的 test() 方法");
        test();
        System.out.println();
        System.out.println("在 子类 的 普通 代码块中调用 静态的 test1() 方法");
        test1();
        System.out.println("------------------------------------------");
    }

    public b(){
        /*
        隐含的内容
        1. super()：默认调用父类的构造器
        2. 调用  本类  的  普通代码块
         */
        System.out.println("调用 子类 的构造器");
        System.out.println("------------------------------------------");
        System.out.println();
        System.out.println("===========子类初始化完成===========\n");
    }

    public static void test(){
        System.out.println("调用 子类 中的 static类型 的 test() 方法");
    }

    @Override
    public void test1(){
        System.out.println("调用 子类 中的 static类型 的 test1() 方法");
    }

}
