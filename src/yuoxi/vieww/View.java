package yuoxi.vieww;

import yuoxi.enty.Level;
import yuoxi.enty.Player;

public interface View {
    public void zhuUser();//注册
    public Player user();//登录
    public String player(Player player);//生成字符串
    public String in();//输入字符串
    public void pk(Player player);//
    public void addlevel();//增加级别
    public void uplevel();//修改级别

}
