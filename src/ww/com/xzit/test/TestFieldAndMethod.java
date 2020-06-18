package ww.com.xzit.test;

import student.enty.Stuedent;
import ww.Book;
import ww.Studenty;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestFieldAndMethod {
    public static void main(String[] args) {
        try {
           Class stuCla= Class.forName( "ww.Studenty" );
            Studenty stuObj=(Studenty)stuCla.newInstance();
            System.out.println(stuCla.getName());
            //获取某个成员字段
            Field nameField=stuCla.getField( "name" );//获取公共级别的属性字段
            nameField.set( stuObj,"任我行" );
            System.out.println(stuObj.name);
            //使用反射方式获取某个字段值
            System.out.println(nameField.get( stuObj ));
            //获取不可见的字段属性
            Field moneyField=stuCla.getDeclaredField( "money" );
            System.out.println(moneyField.getModifiers() );
            //利用运行时动态改变私有字段的访问级别
            moneyField.setAccessible( true );//给私有的属性赋值
            moneyField.set( stuObj,999.99 );
            System.out.println(moneyField.get( stuObj ));
            //Method反射编程
            Book book=new Book();
            book.setName( "天龙八部" );
           Method lrean= stuCla.getMethod( "lrean", Book.class);
           lrean.invoke( stuObj,book );//调用公共方法"
            //获取非公共可见级别的方法
            Method runMet=stuCla.getDeclaredMethod("run");
            runMet.setAccessible( true );
            runMet.invoke( stuObj );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
