package cheeat.view;

import cheeat.dao.DataDao;
import cheeat.dao.DataDaoImpl;
import cheeat.enty.Dish;
import cheeat.enty.Order;
import cheeat.service.OrderDishService;
import cheeat.service.OrderDishServiceImpl;

import java.util.List;
import java.util.Scanner;

 class ViewImpl implements View {
    private OrderDishService service = new OrderDishServiceImpl();
    private Scanner sc = new Scanner(System.in);
    @Override
    public void showMenu() {
        System.out.println("欢迎使用吃货联盟");
        System.out.println("————————————————");
        System.out.println("1。我要订餐");
        System.out.println("2。查看订餐");
        System.out.println("3。签收订单");
        System.out.println("4。删除订单");
        System.out.println("5。我要点赞");
        System.out.println("6。退出系统");
    }

    @Override
    public void orderDish() {
        List h1=service.getDish();
        for (int i=0;i<h1.size();i++){
            System.out.println(h1.get(i));
        }
    }

     @Override
     public void addOrder() {
         List<Dish> g=service.getDish();
         System.out.println("收货人：");
         String eator=sc.next();
         System.out.println("收货地址：");
         String add=sc.next();
         System.out.println("订单编号：");
         int id=sc.nextInt();
         System.out.println("选择你需要的菜名：");
         String name=sc.next();
         for (Dish p:g){
             if (p.getName().equals(name)){
                 name=p.getName();
                 break;
             }else {
                 return;
             }
         }
         System.out.println("选择你需要的数量：");
         int num=sc.nextInt();
         System.out.println("订餐时间");
         int time=sc.nextInt();
         Order order2=new Order();
         order2.setName(name);
         double prce=0;
         for (Dish p:g){
             if (p.getName().equals(name)){
                prce=p.getPrice();
                 break;
             }else {
                 return;
             }
         }
         order2.setTotalPrice(prce*num);
         order2.setStatus(0);
         order2.setTime(time);
         order2.setAddress(add);
         order2.setEator(eator);
         order2.setOrderNo(id);
         order2.setAmount(num);
         service.addOrder(order2);

    }

     @Override
     public void orderQuey() {
         List hh= service.getOrder();
         for (int i=0;i<hh.size();i++){
             System.out.println(hh.get(i));
         }
     }

     @Override
     public void orderDel() {
         orderQuey();
         System.out.println("请输入你需要删除订单号：");
         int id=sc.nextInt();
         service.delete(id);
     }

     @Override
     public void ordeStatus() {
         orderQuey();
         System.out.println("请输入喜欢的菜名：");
         String name=sc.next();
         service.praise(name);
     }

 }
