package ww;

import java.lang.reflect.*;

public class TestClass {
    public static void main(String[] args)   {
        try {
            Class<?>stuClass=Class.forName( "ww.Studenty" );
            System.out.println(stuClass.getName());
            //使用字节码对象获取关于这个类的对象实例
            Studenty stuobj=(Studenty) stuClass.newInstance();//调用无参构造器生成实例
            System.out.println(stuobj!=null);
            System.out.println(stuClass.getModifiers()== Modifier.PUBLIC ); //获取类的访问级别
            //获取所有公共级别的字段
            Field[] fields=stuClass.getFields();
            System.out.println(fields.length);
            //获取所有级别的字段(成员属性）
            Field[] fields1=stuClass.getDeclaredFields();
            System.out.println(fields1.length);
            //获取类中定义的无参构造器
            Constructor conp=stuClass.getConstructor(  );
            System.out.println(conp!=null);
            //获取指定构造器
            Constructor conp3=stuClass.getConstructor( String.class,Integer.class );
            System.out.println(conp3!=null);
            //获取类中定义的所有构造器
            Constructor< ? >[] conp1=stuClass.getConstructors(  );
            System.out.println(conp1.length);
            //获取类中所有公共级别的定义的方法
            Method[] gg= stuClass.getMethods();
            System.out.println(gg.length);




        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
