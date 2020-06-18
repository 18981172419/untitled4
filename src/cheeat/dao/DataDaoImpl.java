package cheeat.dao;

import cheeat.enty.*;
import cheeat.util.FileTools;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataDaoImpl implements DataDao{
    public static final String DIR1 ="f:\\yy\\dish.txt";//存放菜谱
    public static final String DIR2 ="f:\\yy\\order.txt";//存放订单
    @Override
    public List< Dish > readDishDatta() {
        FileReader fis=null;//创建读取文件
        BufferedReader br=null;//创建写入文件
        List<Dish> result=new ArrayList<>();//创建一个集合
        try {
            fis = new FileReader(DIR1);//读文件
            br = new BufferedReader(fis);//
            String tepm = null;//设置一个接收字符的变量
            while ((tepm = br.readLine()) != null) {
                Dish dish = new Dish();//创建菜谱
                String[] arr = tepm.split(",");//从，号分割再装入数组
                dish.setName(arr[0]);
                dish.setPrice(Double.parseDouble(arr[1]));
                dish.setClick(Integer.parseInt(arr[2]));
                result.add(dish);//装入对像
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        } finally {
            FileTools.close(br);
            FileTools.close(fis);
        }

        return result;
    }

    @Override
    public List< Order > readOrderDatta() {//读取订单
        FileReader fis1=null;//创建读取文件
        BufferedReader br1=null;//创建写入文件
        List< Order > result1=new ArrayList<>();//创建一个集合
        try {
            fis1 = new FileReader(DIR2);//读文件
            br1 = new BufferedReader(fis1);//
            String tepm1 = null;//设置一个接收字符的变量
            while ((tepm1 = br1.readLine()) != null) {
                Order order = new Order();//创建订单
                String[] arra = tepm1.split(",");//从，号分割再装入数组
               order.setOrderNo(Integer.parseInt(arra[0]));//编号
               order.setAddress(arra[1]);//地址
               order.setAmount(Integer.parseInt(arra[2]));//数量
               order.setEator(arra[3]);//吃货
               order.setName(arra[4]);//菜名
               order.setStatus(Integer.parseInt(arra[5]));//状态
               order.setTime(Integer.parseInt(arra[6]));//时间
                 order.setTotalPrice(Double.parseDouble(arra[7]));//总价
                result1.add(order);//装入对像
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        } finally {
            FileTools.close(br1);
            FileTools.close(fis1);
        }

        return result1;
    }

    @Override
    public void writeData(List< Order > list) {//写入订单
        FileWriter fiw=null;
        try {
            fiw=new FileWriter(DIR2,true);
          if (list.isEmpty()){
            fiw.write("");
            fiw.flush();
            return;
          }
          for (Order hh:list){
              StringBuilder sb= new StringBuilder();
              sb.append(hh.getOrderNo()).append(",");
              sb.append(hh.getAddress()).append(",");
              sb.append(hh.getAmount()).append(",");
              sb.append(hh.getEator()).append(",");
              sb.append(hh.getName()).append(",");
              sb.append(hh.getStatus()).append(",");
              sb.append(hh.getTime()).append(",");
              sb.append(hh.getTotalPrice()).append("\n");

              fiw.write(sb.toString());//将字符串起来
              fiw.flush();//刷新缓存区立即保存到文件
          }
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }finally {
            FileTools.close(fiw);
        }
    }

    @Override
    public void clck(List< Dish > list) {
            FileWriter fiw=null;
            try {
                fiw=new FileWriter(DIR1,false);
                if (list.isEmpty()){
                    fiw.write("");
                    fiw.flush();
                    return;
                }
                for (Dish hh:list){
                    StringBuilder sb= new StringBuilder();
                    sb.append(hh.getName()).append(",");
                    sb.append(hh.getPrice()).append(",");
                    sb.append(hh.getClick()).append("\n");
                    fiw.write(sb.toString());//将字符串起来
                    fiw.flush();//刷新缓存区立即保存到文件
                }
            } catch (IOException e) {
                throw  new RuntimeException(e);
            }finally {
                FileTools.close(fiw);
            }
        }


    @Override
    public boolean addData(Order order) {//新增订单
        List< Order > list=new ArrayList< Order >();
        list.add(order);
        writeData(list);
        return true;
    }

    @Override
    public boolean deleteData(int orderNo) {
        List< Order > list= readOrderDatta();
        for (Order order1:list){
            if (orderNo==order1.getOrderNo()){
                list.remove(order1);
               writeData2(list);
                return true;
            }

        }return false;

    }

    @Override
    public boolean upData(int orderNo) {
        List< Order > list= readOrderDatta();
        for (Order order1:list){
            if (orderNo==order1.getOrderNo()){
                list.remove(order1);
                order1.setStatus(1);
                list.add(order1);
                writeData2(list);
                return true;
            }

        }return false;

    }


    @Override
    public boolean praise(String name) {
        List< Dish > list= readDishDatta();
        for (Dish dish1:list){
            if (name.equals(dish1.getName())){
                list.remove(name);
                dish1.setClick(dish1.getClick()+1);
                list.add(dish1);
                clck(list);
                return true;
            }

        }return false;

    }

    @Override
    public void writeData2(List< Order > list) {
        FileWriter fiw=null;
        try {
            fiw=new FileWriter(DIR2,false);
            if (list.isEmpty()){
                fiw.write("");
                fiw.flush();
                return;
            }
            for (Order hh:list){
                StringBuilder sb= new StringBuilder();
                sb.append(hh.getOrderNo()).append(",");
                sb.append(hh.getAddress()).append(",");
                sb.append(hh.getAmount()).append(",");
                sb.append(hh.getEator()).append(",");
                sb.append(hh.getName()).append(",");
                sb.append(hh.getStatus()).append(",");
                sb.append(hh.getTime()).append(",");
                sb.append(hh.getTotalPrice()).append("\n");

                fiw.write(sb.toString());//将字符串起来
                fiw.flush();//刷新缓存区立即保存到文件
            }
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }finally {
            FileTools.close(fiw);
        }
    }

}
