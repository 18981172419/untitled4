package student.dao;

import student.enty.Kmenu;
import student.enty.SteToTeach;
import student.enty.Stuedent;
import student.enty.Teacher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Dao dao=new DaoImpl();
        int num=0;
        Scanner sc=new Scanner( System.in );
        System.out.println("欢迎进入选学系统");
        System.out.println("1。添加学生信息：");
        System.out.println("2。添加教师信息：");
        System.out.println("3。查询学生信息：");
        System.out.println("4。查询教师信息：");
        System.out.println("5。添加专业课：");
        System.out.println("6。查询专业课：");
        System.out.println("7。学生选课：");
        System.out.println("8。查询学生就读专业：");
        System.out.println("退出：");
        int chose=sc.nextInt();
        boolean flag=false;
        switch (chose){
            case 1:
                System.out.println("学生信息登记");
                List< Stuedent > hh=dao.queyStudent();
                List list=new ArrayList(  );
                for (Stuedent jj:hh){
                   int s= jj.getId();
                    list.add( s );
                }
                    int h=(int)Collections.max( list );
                int id= h+1;
                System.out.println("请输入姓名：");
                String name=sc.next();
                System.out.println("请输入性别：");
                String sex=sc.next();
                System.out.println("请输入年龄：");
                String age=sc.next();
                Stuedent st=new Stuedent(id,name,sex,age);
                List list1=new ArrayList(  );
                System.out.println(st);
                list1.add( st );
                dao.addStudent( list1 );
                break;
            case 2:
                System.out.println("教师信息登记");
                List< Teacher > hh1=dao.queyTeacher();
                List list2=new ArrayList(  );
                for (Teacher jj:hh1){
                    int s1= jj.getId();
                    list2.add( s1);
                }
                int h1=(int)Collections.max( list2 );
                int id1= h1+1;
                System.out.println("请输入姓名：");
                String name1=sc.next();
                System.out.println("请输入专业编号：");
                int kmenuid=sc.nextInt();
                Teacher tst=new Teacher(id1,name1,kmenuid);
                List list3=new ArrayList(  );
                System.out.println(tst);
                list3.add( tst );
                dao.addTeacher( list3 );
                break;
            case 3:
               List<Stuedent>l= dao.queyStudent();
               for (Stuedent k:l){
                   System.out.println(k);
               }

                break;
            case 4:
                List<Teacher>p= dao.queyTeacher();
                for (Teacher k:p){
                    System.out.println(k);
                }
                break;
            case 5:
                System.out.println("专业信息登记");
                List< Kmenu > hh4=dao.queyKmenu();
                List list4=new ArrayList(  );
                for (Kmenu jj:hh4){
                    int s1= jj.getKmenuid();
                    list4.add( s1);
                }
                int h4=(int)Collections.max( list4 );
                int id4= h4+1;
                System.out.println("请输入专业：");
                String kmenu=sc.next();
                Kmenu kst=new Kmenu(id4,kmenu);
                List list5=new ArrayList(  );
                System.out.println(kst);
                list5.add( kst );
                dao.addKmenu( list5 );
                break;
            case 6:
                List<Kmenu>p1= dao.queyKmenu();
                for (Kmenu k:p1){
                    System.out.println(k);
                }
                break;
            case 7:
               do {
                   List<Stuedent>l1= dao.queyStudent();
                   for (Stuedent k:l1){//查询学生信息
                       System.out.println(k);
                   }
                   System.out.println("请选择学生编号：" );
                   int rd=sc.nextInt();
                   List<Teacher>p3= dao.queyTeacher();//查询教师信息
                   for (Teacher k:p3){
                       System.out.println(k);
                   }
                   System.out.println("请选择老师编号：" );
                   int Tea=sc.nextInt();
                   SteToTeach stt=new SteToTeach( rd,Tea );
                   List<SteToTeach>  sttg=new ArrayList<>(  );
                   sttg.add( stt );
                   dao.addeStetoTeach( sttg );
                   System.out.println("是否还继续选专业：Y/N");
                   String bb=sc.next();
                   if (bb.equals("Y")){
                       flag=false;
                   }else {
                       flag=true;
                   }
               }while (!flag);

                break;
            case 8:
                System.out.println("查询学生所读就专业信息");
                List<SteToTeach> M=dao.queySteToTeach();
                SteToTeach MB=null;
                for (SteToTeach F:M){
                    MB=F;
                    List<Stuedent> stuedents= dao.queyStudent();
                    List<Teacher>teachers= dao.queyTeacher();
                    List<Kmenu>kmenus= dao.queyKmenu();
                    for (Stuedent FG:stuedents){
                        if (FG==null)break;
                        if (MB.getStudentid()==FG.getId()){
                            for (Teacher JK:teachers){
                                if (MB.getTeachid()==JK.getId()){
                                    for (Kmenu sa:kmenus){
                                        if (JK.getKemid()==sa.getKmenuid()){

                                            System.out.println("学员姓名"+"\t"+FG.getName()+"\t"+"授课老师："+JK.getName()+"\t"+"所学专业"+"\t"+sa.getKmenuName());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            default:
                break;
        }



       ;
    }
}
