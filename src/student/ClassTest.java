package student;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ClassTest {
    private ClassTest(){

    }
    public ClassTest(String name){
        System.out.println("执行有参数的构造器");
    }
    public void info(){
        System.out.println("执行无糁数的info方法");
    }
    public void info(String str){
        System.out.println("执行有参数的info方法"+",其str参数值："+str);

    }
    class Inner{
    }
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException {
        Class< ClassTest > clazz = ClassTest.class;
        //获取clazz对明所对应类的全部构造器
        Constructor< ? >[] ctros = clazz.getDeclaredConstructors();
        System.out.println("ClassTest的全部构造如下：");
        for (Constructor c : ctros) {
            System.out.println(c);
        }
        //获取calzz对象所对应类的全部public构造器
        Constructor< ? >[] publicCtros = clazz.getConstructors();
        System.out.println("ClassTest的全部public构造如下：");
        for (Constructor c : publicCtros) {
            System.out.println(c);
        }
        //获取clazz对象所对应类的全部public方法
        Method[] mtds = clazz.getMethods();
        System.out.println("ClassTest的全部public方法如下");
        for (Method md : mtds) {
            System.out.println(md);
        }
        //获取clazz对象所对应类指定方法
        System.out.println("ClassTest里带一个字符串参数的info方法为"+clazz.getMethod("info",String.class));
        //获取clazz对象所对应类的全部注解
        Annotation[]anns=clazz.getAnnotations();
        System.out.println("ClassTest的全部Annotation如下");
        for (Annotation an : anns) {
            System.out.println(an);
        }
        //获取clazz对象所对应类的全部内部类
        Class<?>[]inners=clazz.getDeclaredClasses();
        System.out.println("ClassTest的全部内部类如下");
        for (Class c : inners) {
            System.out.println(c);
        }
        //使用Class.forName()方法加载ClassTest的Inner内部类
        Class inClazz=Class.forName("student.ClassTest$Inner");
        //访问该类所在的外部类
        System.out.println("inClass对应类的外部类为："+inClazz.getDeclaredClasses());
        System.out.println("ClassTest的包为："+clazz.getPackage());
        System.out.println("ClassTest的父类为："+clazz.getSuperclass());

    }


}
