package student;

import javax.swing.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GreateJFrame {
    public static void main(String[] args) throws Exception {
        JFrame jf=new JFrame();
        Class<?>jframeClazz=Class.forName("javax.swing.JFrame");//加载java类信息
        //选择使用指定的构造器
        Constructor ctor=jframeClazz.getConstructor(String.class);//获取这个类的具体松造方法，根据传入的参数类型
        Object obj=ctor.newInstance("测试窗口");//创建java对象
        System.out.println(obj);
        Method mtd=jframeClazz.getMethod("show");//调用show方法，显示窗体获取普通show方法
        mtd.invoke(obj,null);//执行普通show方法，show方法是无参方法，所以参的位置传递null

    }
}
