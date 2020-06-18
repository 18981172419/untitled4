package yuoxi.dao;

import yuoxi.enty.Level;
import yuoxi.enty.Player;

import java.util.List;

public interface Dao {
    public boolean zuplayer(Player player);//注册登录
    public  List queyUser();//查询所有游戏玩家
    public List queyLevel();//查询所有游戏级别
    public boolean user(Player player);//录登
    public void writePlayer(List<Player> list );//写入游戏玩家
    public void writeLevel(List< Level > list);//写入级别




}
