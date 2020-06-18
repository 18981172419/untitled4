package yuoxi.hetai;

import yuoxi.dao.Dao;
import yuoxi.dao.DaoImpl;
import yuoxi.enty.Level;
import yuoxi.sevice.Sevice;
import yuoxi.sevice.SeviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hetai {
Scanner sc=new Scanner(System.in);
    Sevice ss = new SeviceImpl();
    Dao dd = new DaoImpl();
    public Level upLevel(int leveNo ) {//修改级别
        Sevice ss = new SeviceImpl();
        Dao dd = new DaoImpl();
        List< Level > p = dd.queyLevel();
        for (Level k : p) {
            if (leveNo == k.getLevelNo()) {
                System.out.println(k);
                System.out.println("请修改字符串长度：");
                int l=sc.nextInt();
                k.setStrlength(l);
                System.out.println("请修改闯关时间：");
                int m=sc.nextInt();
                k.setTimeLimit(m);
                System.out.println("请修改输入次数：");
                int h=sc.nextInt();
                k.setStrTimes(h);
                System.out.println(k);
                return k;
            }
        }
        return null;
    }
    public void addLevel(Level level ){//增加级别
        List<Level >list=new ArrayList<>();
        list.add(level);
        dd.writeLevel(list);
    }
    public void upLevel(Level level ){//修改级别
        List<Level >list=new ArrayList<>();
        List<Level>m= dd.queyLevel();
        m.remove(level);//先删除先有的级别
        m.add(level);//再添加最新修改的级别
        System.out.println(m);
        dd.writeLevel(m);//追加级别
    }
    public static void main(String[] args) {
        Hetai h=new Hetai();
        h.upLevel(8);

    }

}
