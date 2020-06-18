package cheeat.dao;

import cheeat.enty.*;

import java.util.List;

public interface DataDao {
    public List< Dish > readDishDatta();//读取菜谱
    public List< Order > readOrderDatta();//从文本件读取订单信息
    public void writeData(List<Order>list);//向文本文件写订单数据
    public void clck(List<Dish>list);//向文本文件写菜谱数据
    public boolean addData(Order order);//新增订单
    public boolean deleteData(int orderNo);//删除订单
    public boolean upData(int orderNo);//签收订单
    public boolean praise(String name);//点赞
    public void writeData2(List<Order>list);//向文本文件写订单数据

}
