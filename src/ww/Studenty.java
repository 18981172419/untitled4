package ww;

public class Studenty {
    public String name;
    protected int age;
    double height;
    private double money;

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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Studenty() {
    }

    public Studenty(String name, int age, double height, double money) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.money = money;
    }

    public Studenty(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Studenty(String name, Integer age, Double money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }
    public void lrean(Book book){
        System.out.println("我的名字是："+name+"我正在学习"+book.getName());
    }
     void run(){
        System.out.println("我们喜欢运动");
    }
}
