//package student;
//
//import student.enty.Stuedent;
//import student.enty.Teacher;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class TestClass {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        Stuedent st=new Stuedent(1,"梁少龙","语文");
//        Stuedent st1=new Stuedent(2,"左龙","数学");
//        Stuedent st2=new Stuedent(3,"U龙","语文");
//        Teacher te=new Teacher(1,"张老师","语文");
//        Teacher te1=new Teacher(2,"王老师","数学");
//        List<Stuedent> list=new ArrayList<>();//学生集合
//        list.add(st);
//        list.add(st1);
//        list.add(st2);
//        List<Teacher> list1=new ArrayList<>();//老师集合
//        list1.add(te);
//        list1.add(te1);
//        System.out.println("请输入学生姓名：");
//        String a=sc.next();
//        for (Stuedent k:list){
//            if (k.getName().equals(a)){
//                for (Teacher h:list1){
//                    if (k.getKemu().equals(h.getKem())){
//                    System.out.println(k+"任课老师："+h.getName());
//                    }
//                }
//            }
//        }
//
//        //查询专业下的学生
//        System.out.println("请输入课程：");
//        String kmenu=sc.next();
//        for (Stuedent k:list){
//            if (k.getKemu().equals(kmenu))
//            System.out.println("专业"+kmenu+":"+k.getName());
//        }
//    }
//}
