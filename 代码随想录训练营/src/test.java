import java.util.ArrayList;

public class test {
    public static void main(String[] args) {

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        for (Integer integer : integers) {
            System.out.println(integer);
        }

        s s = new s();
        s.show();
    }
    
}

class s{
    public void show(){
        System.out.println("hello");
    }
}