package practise;


public class pra {
    public static void main(String[] args) {
        ccc ccc = new ccc();
        // 运行类型是 bbb，根据动态绑定机制，会调用 bbb 的 hi（）方法
        bbb bbb = new bbb();
        ccc.hi(bbb);
    }
}

interface aaa{
    // 默认是 public abstract 修饰
    void hi();
}

class bbb implements aaa{
    @Override
    public void hi() {
        System.out.println("调用了 bbb 类的 hi（）方法");
    }
}

class ccc {
    public void hi(aaa interFace) {
        interFace.hi();
    }
}