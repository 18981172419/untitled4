package cheeat.view;

import cheeat.service.OrderDishService;
import cheeat.service.OrderDishServiceImpl;
import cheeat.enty.*;
import java.util.Scanner;
import java.util.List;
public interface View {
    public void showMenu();//显示菜谱
    public void orderDish();//获取菜谱
    public void addOrder();//新增订单
    public void orderQuey();//查询订单
    public void orderDel();//删除订单
    public void ordeStatus();//签收
}

