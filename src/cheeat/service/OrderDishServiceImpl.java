package cheeat.service;

import cheeat.dao.DataDao;
import cheeat.dao.DataDaoImpl;
import cheeat.enty.Dish;
import cheeat.enty.Order;

import java.util.List;

public class OrderDishServiceImpl implements OrderDishService {
    private DataDao dao=new DataDaoImpl();
    @Override
    public List< Dish > getDish() {
       List a= dao.readDishDatta();
        return a;
    }

    @Override
    public List< Order > getOrder() {
        List a=dao.readOrderDatta();
        return a;
    }

    @Override
    public String addOrder(Order order) {
        if (order!=null){
            dao.addData(order);
        }
        return null;
    }

    @Override
    public String delete(int  orderNo) {
        dao.deleteData(orderNo);
        return null;
    }

    @Override
    public String modifyOrder(int status) {
        dao.upData(status);
        return null;
    }

    @Override
    public boolean praise(String name) {
        dao.praise(name);
        return false;
    }
}
