package cheeat.service;

import cheeat.enty.*;
import java.util.List;
public interface OrderDishService {
    public List< Dish > getDish();//查询菜品
    public List<Order>getOrder();//查询订单
    public String addOrder(Order order);//新增
    public String delete(int  orderNo);//删除
    public String modifyOrder(int status);//签收
    public boolean praise(String name);//点赞
}
