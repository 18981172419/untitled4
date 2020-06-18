package yuoxi.vieww;

import yuoxi.enty.Level;
import yuoxi.enty.Player;
import yuoxi.hetai.Hetai;
import yuoxi.sevice.Sevice;
import yuoxi.sevice.SeviceImpl;

import java.util.List;
import java.util.Scanner;

public class ViewImpl implements View {
    Hetai hetai=new Hetai();
    Sevice sevice= new SeviceImpl();
    Scanner sc=new Scanner(System.in);
    int id=0;
    @Override
    public void zhuUser() {
        System.out.println("请输入用户名：");
        String user=sc.next();
        System.out.println("请输入密码：");
        String pass=sc.next();
        List<Player> uss=sevice.queyUser();
       if (uss!=null){
           id=uss.size()+1;
       }
        Player player=new Player(id,pass,user);
        sevice.zhuUser(player);
    }

    @Override
    public Player user() {
        System.out.println("欢迎进入登录界面");
        System.out.println("请输入帐号：");
        String use=sc.next();
        System.out.println("请输入密码：");
        String pass=sc.next();
        List<Player> uss=sevice.queyUser();
        Player a=null;
        for (int i=0;i<uss.size();i++){
            if ((uss.get(i).getUser().equals(use))&&(uss.get(i).getPass().equals(pass))){
                System.out.println("欢迎进入游戏！！1");
                uss.get(i).setStartTime(System.currentTimeMillis());
                return uss.get(i);
            }
        }
        System.out.println("你的帐号有问题");
        return  null;
    }

    @Override
    public String player(Player player) {//输出字符串
       return sevice.printStr(player);


    }

    @Override
    public String in() {//输入字符串
        return sc.next();
    }

    @Override
    public void pk(Player player) {//游戏
        String p=player(player);
        System.out.println(p);
        String k=in();
        Sevice ss=new SeviceImpl();
        ss.intOrOut(p,k,player);
    }

    @Override
    public void addlevel() {
        System.out.println("你好！请输入级别号：");
        int leve1NO=sc.nextInt();
        System.out.println("请输入字符串长度：");
        int strlength=sc.nextInt();
        System.out.println("请输入字符串次数：");
        int strTimes=sc.nextInt();
        System.out.println("请输入闯关时间：");
        int timeLimit=sc.nextInt();
        System.out.println("请输入每次积分：");
        int perscrore=sc.nextInt();
        Level level=new Level(leve1NO,strlength,strTimes,timeLimit,perscrore);
        hetai.addLevel(level);


    }

    @Override
    public void uplevel() {
        System.out.println("请输入你需要修改的级别：");

        Level l=hetai.upLevel(sc.nextInt());
        hetai.upLevel(l);
    }
}
