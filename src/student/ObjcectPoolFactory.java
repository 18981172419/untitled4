package student;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ObjcectPoolFactory {
    //定义一个对象池，前面是对象名，后面是实际对象
    private Map< String, Object > objectPool = new HashMap<>();
    private Properties config = new Properties();

    //初始化Properties对象
    public void init() {
        config.put("a", "java.util.Date");
        config.put("b", "javax.swing.JFrame");
        config.put("b%Title", "TestClass Title");

    }

    //定义创建对象的方法
    private Object createObject(String clazzName) throws InstantiationException,
            IllegalAccessException, ClassNotFoundException {
        //根据字符串来获取对应的Class对象
        Class< ? > clazz = Class.forName(clazzName);
        //使用clazz对应类的默认构造器创建实例
        return clazz.newInstance();
    }

    //初始化对象池
    public void initPool() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        for (String name : config.stringPropertyNames()) {
            if (!name.contains("%")) {
                String[] objAndProp = name.split("%");
                objectPool.put(name, createObject(config.getProperty(name)));//根据名得到类，再创建类
            }
        }
    }

    //根据属性文件来调用指定对象的setter方法
    public void initProperty() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        for (String name : config.stringPropertyNames()) {
            if (name.contains("%")) {
                String[] objAndProp = name.split("%");//如果包含%就从这里分割
                Object target = getObject(objAndProp[0]);
                String mtdName = "set" + objAndProp[1];
                //通过 target 的 个体Class（）获取它的实现类所对应的Class对象
                Class< ? > targetClass = target.getClass();
                //获取希望调用的setter 方法
                Method mtd = targetClass.getMethod(mtdName, String.class);
                //通过Method的invoke方法执行setter方法
                mtd.invoke(target, config.getProperty(name));
            }
        }
    }

    public Object getObject(String name) {
        //从objectPool中取出指定name对应的对象
        return objectPool.get(name);
    }

    public static void main(String[] args) throws Exception {
        ObjcectPoolFactory pf = new ObjcectPoolFactory();
        pf.init();
        pf.initPool();
        pf.initProperty();
        System.out.println(pf.getObject("a"));
    }

}