package student;
import java.util.Date;
public class GenericsObjectFactory {
    public static <T> T getinstance(Class<T>cls){
        try{
            return cls.newInstance();//建立对象，调用无参的构造方法等价于DATE date=new DATE()
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        //获取实例后无需进行类型转换
        Date d=GenericsObjectFactory.getinstance(Date.class);
        System.out.println(d);
    }
}
