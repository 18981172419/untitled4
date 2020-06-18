package yuoxi.vieww;

import yuoxi.enty.Level;
import yuoxi.enty.Player;
import yuoxi.sevice.Sevice;
import yuoxi.sevice.SeviceImpl;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        View view=new ViewImpl();
        int num=-1;
        boolean isExit=false;
        do {
            System.out.println("欢迎进入游戏");
            System.out.println("1.注册用户");
            System.out.println("2.登录用户");
            System.out.println("3.后台管理");
            System.out.println("4.退出");
            System.out.println("请选择你需要的项目：");
            int chose =sc.nextInt();
            if (!isExit){
                System.out.println("输入0返回：");
                num=sc.nextInt();
            }else {
                break;
            }
       switch (chose){
           case 1:
               System.out.println("注册用户");
                   view.zhuUser();
               break;
           case 2:
               System.out.println("登录用户");
               Player player1=view.user();//登录
               System.out.println(player1);
               while (true){
                   view.pk(player1);
               }
           case 3:
               System.out.println("后台管理");
               System.out.println("1.修改级别");
               System.out.println("2.增加级别");
               System.out.println("3.退也");
               System.out.println("请输入编号：");
               int hh=sc.nextInt();
               switch (hh){
                   case 1:
                       System.out.println("1.修改级别");
                       view.uplevel();
                       break;
                   case 2:
                       System.out.println("2.增加级别");
                       view.addlevel();
                       break;
                   default:
                       System.out.println("退出");
                       num=0;
                       break;
               }
           default:
               isExit=true;
               break;


       }
        }while (num==0);


    }
}
