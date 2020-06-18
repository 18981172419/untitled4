package student;
import java.lang.reflect.Field;

import static javafx.scene.input.KeyCode.P;

public class FieldTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person p=new Person();
        Class<Person> personClazz=Person.class;
        Field nameField=personClazz.getDeclaredField("name");
        nameField.setAccessible(true);//如果是prviate修饰的属性，
        nameField.set(p,"crazy");
        Field ageField=personClazz.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(p,30);
        System.out.println(p);
    }
}
