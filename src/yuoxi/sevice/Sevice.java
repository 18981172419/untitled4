package yuoxi.sevice;

import yuoxi.enty.Level;
import yuoxi.enty.Player;

import java.util.List;

public interface Sevice {
    public void zhuUser(Player player);//用户名登录
    public Player user(Player player);//登录
    public List< Player > queyUser();//查询所有用户名
    public List< Level > queryLeve();//查询所有级别
    public String printStr(Player player);//打印字符串
    public Level level(Player player);//得到一个相同的对象
    public boolean chaoshi(Player player);//判断是否超时
    public boolean intOrOut(String out,String in,Player player );//判断输入是否正确
    public int addScore(Player player);//增加积分
    //判断玩家积分是否足够升级,如果够就升级
    public void levelUp(Player player);

}
