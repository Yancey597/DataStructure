/**
 * @author Yancey
 * @version 1.0
 * @className yancey
 * @date 2023/12/26-23:13
 * @description TODO
 */

public class yancey { // 父类
    private int age;
    public yancey(int age) {
        this.age = age;
    }
    public void print(){
        System.out.println("Father");
    }
}
class good extends yancey{// 子类
    private int name;

    public good(int age, int name) {
        super(age);
        this.name = name;
    }
//    @Override
//    public void print(){
//        System.out.println("subclass");
//    }

    public static void main(String[] args) {
        yancey yancey = new yancey(123);
        good good = new good(12, 12);
//        good.print();
//        yancey.print();

        yancey qew = new good(1,12);
        qew.print();
    }
}
