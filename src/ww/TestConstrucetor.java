package ww;

import java.lang.reflect.Constructor;

public class TestConstrucetor {
    public static void main(String[] args) {
        try {
           Class<?>stuCla= Class.forName( "ww.Studenty" );
            //获取构造器
            Constructor cons=stuCla.getConstructor( String.class,Integer.class );
            //使用构造反射相关方法实现对象的创那家
           Studenty stuObj=(Studenty) cons.newInstance( "东方不败",36 );
            System.out.println(stuObj.toString());
            System.out.println(stuObj.name);
            System.out.println(stuObj.getAge());
            System.out.println("构造器的访问级别是："+cons.getModifiers());
            System.out.println("参数的个数："+cons.getParameterCount());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
