package yuoxi.sevice;

import yuoxi.dao.Dao;
import yuoxi.dao.DaoImpl;
import yuoxi.enty.Level;
import yuoxi.enty.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SeviceImpl implements Sevice{
    Dao dao=new DaoImpl();
    int no;
    @Override
    public void zhuUser(Player player) {//注册帐户
        boolean hh=dao.zuplayer(player);
        List<Player> list=new ArrayList<>();
        if (hh){
            list.add(player);
            dao.writePlayer(list);
            System.out.println("注册成功！！！");
        }else {
            System.out.println("输入有误！！！");;
        }

    }

    @Override
    public Player user(Player player) {//登录帐户
       boolean hh=dao.user(player);
        if (hh){
            return player;
        }
        return null;

    }

    @Override
    public List< Player > queyUser() {//查询玩家
        List ss=dao.queyUser();
        return ss;
    }

    @Override
    public List< Level >  queryLeve() {//查询级别
       return dao.queyLevel();

    }
    @Override
    public String printStr(Player player) { //打印字符串
        Random random = new Random();
        StringBuffer buffer=new StringBuffer();
        if (player!=null)
        for (int i = 0; i <(level(player)).getStrlength();i++) {
            int rand = random.nextInt(7); // 产生随机数
            // 根据随机数拼接字符串
            switch (rand) {
                case 0:
                    buffer.append("1");
                    break;
                case 1:
                    buffer.append("2");
                    break;
                case 2:
                    buffer.append("3");
                    break;
                case 3:
                    buffer.append("4");
                    break;
                case 4:
                    buffer.append("5");
                    break;
                case 5:
                    buffer.append("6");
                    break;
                case 6:
                    buffer.append("7");
                    break;
            }
        }
        return buffer.toString();
    }

    @Override
    public Level level(Player player) {//查询当前对象
        List<Level> kk=queryLeve();
        for (Level j:kk){
            if (player.getLevelNo()==j.getLevelNo()){
                return j;
            }
        }
        return null;
    }

    @Override
    public boolean chaoshi(Player player) {//判断是否超时
        long currentTime=System.currentTimeMillis();//获取时间
        int a=0;
        a= level(player).getTimeLimit();
        if ((currentTime- player.getStartTime())/1000>a){
            System.out.println("你输入的太慢了");
            System.exit(1);
            return false;
        }else {
            return true;
        }

    }

    @Override
    public boolean intOrOut(String out, String in, Player player) {//判断是否正确
        if(out.equals(in)){
            if(!chaoshi(player)){
                System.out.println("你输入太慢了，已超时，退出");
                System.exit(1);
            }else{
                int a=addScore(player);
                player.setCurrScrore(a);
                System.out.println("输入正确，当前级别："+ player.getLevelNo()+"\t当前积分："+player.getCurrScrore()
                        +"\t已用时间："+(System.currentTimeMillis()-player.getStartTime())/1000+"秒");

              levelUp(player);
            }
        }else{
            System.out.println("输入错误，退出");
            System.exit(1);
        }
        return true;
    }

    @Override
    public int addScore(Player player) {//增加积分
        player.setCurrScrore(player.getCurrScrore()+level(player).getPerscrore());
        return player.getCurrScrore();
    }

    @Override
    public void levelUp(Player player) {//升级
        if (player.getCurrScrore()==level(player).getPerscrore()*level(player).getStrTimes()){
            player.setLevelNo(player.getLevelNo()+1);
            player.setCurrScrore(0);
            player.setElapsedTime(0);
            player.setStartTime(System.currentTimeMillis());
        }
    }

}
