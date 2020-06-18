package yuoxi.dao;
import yuoxi.enty.Level;
import yuoxi.enty.Player;
import yuoxi.filetool.FileTool;

import javax.jws.soap.SOAPBinding;
import javax.xml.crypto.URIReferenceException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class DaoImpl implements Dao {
    public static final String DIR1 = "f:\\yy\\leve.txt";//游戏级别
    public static final String DIR2 = "f:\\yy\\user.txt";//用户

    @Override
    public boolean zuplayer(Player player) {//注册用户
        List< Player > user = queyUser();
        for (int i = 0; i < user.size(); i++) {
           if (user.get(i)==null&&(user.get(i).getUser().equals(player.getUser())) || (user.get(i).getPass()).equals(player.getPass())) {
                System.out.println("你的用户名同名或者密码有问题");
                return false;
            }
        }
        return true;
    }

    @Override
    public List queyUser() {//查询用户
        FileReader fis1 = null;//创建读取文件
        BufferedReader br1 = null;//创建写入文件
        List< Player > result1 = new ArrayList<>();//创建一个集合

        try {
            fis1 = new FileReader(DIR2);//根据地址打到文件
            br1 = new BufferedReader(fis1);//把读到的文字弄到缓冲区
            String ss = null;//设置 一个变量接收字符
            while ((ss = br1.readLine()) != null) {
                Player player = new Player();
                String[] arr = ss.split(",");
                //int id, int levelNo, int currScrore, long startTime, int elapsedTime, String pass, String user
                player.setId(Integer.parseInt(arr[0]));
                player.setLevelNo(Integer.parseInt(arr[1]));
                player.setCurrScrore(Integer.parseInt(arr[2]));
                player.setStartTime(Long.parseLong(arr[3]));
                player.setElapsedTime(Integer.parseInt(arr[4]));
                player.setPass(arr[5]);
                player.setUser(arr[6]);
                result1.add(player);//装入对象
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            FileTool.close(fis1);
            FileTool.close(br1);

        }

        return result1;
    }

    @Override
    public List queyLevel() {//查询级别
        FileReader fis2 = null;//创建读取文件
        BufferedReader br2 = null;//创建写入文件
        List< Level > result2 = new ArrayList<>();//创建一个集合

        try {
            fis2 = new FileReader(DIR1);//根据地址打到文件
            br2 = new BufferedReader(fis2);//把读到的文字弄到缓冲区
            String ss = null;//设置 一个变量接收字符
            while ((ss = br2.readLine()) != null) {
                Level level = new Level();
                String[] arr = ss.split(",");
                level.setLevelNo(Integer.parseInt(arr[0]));
                level.setStrlength(Integer.parseInt(arr[1]));
                level.setStrTimes(Integer.parseInt(arr[2]));
                level.setTimeLimit(Integer.parseInt(arr[3]));
                level.setPerscrore(Integer.parseInt(arr[4]));
                result2.add(level);//装入对象
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            FileTool.close(fis2);
            FileTool.close(br2);

        }
        return result2;
    }

    @Override
    public boolean user(Player player) {//判断登录用户是否正确
        List< Player > user = queyUser();
        for (int i = 0; i < user.size(); i++) {
            if ((user.get(i).getUser().equals(player.getUser())) && (user.get(i).getPass()).equals(player.getPass())) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void writePlayer(List<Player> list) {//增加用户
        FileWriter fiw = null;
        try {
            fiw = new FileWriter(DIR2, true);
            if (list.isEmpty()) {
                fiw.write("");
                fiw.flush();
                return;
            }
            for (Player hh:list){
                StringBuilder ss=new StringBuilder();
                //int id, int levelNo, int currScrore, long startTime, int elapsedTime, String pass, String user
                ss.append(hh.getId()).append(",");
                ss.append(hh.getLevelNo()).append(",");
                ss.append(hh.getCurrScrore()).append(",");
                ss.append(hh.getStartTime()).append(",");
                ss.append(hh.getElapsedTime()).append(",");
                ss.append(hh.getPass()).append(",");
                ss.append(hh.getUser()).append("\n");
                fiw.write(ss.toString());
                fiw.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            FileTool.close(fiw);

        }
    }

    @Override
    public void writeLevel(List< Level > list) {//写入级别追加
        FileWriter fiw=null;//创建一个空白的写入文件
        try {
            fiw=new FileWriter(DIR1, true);//创建写入的地址
            if (list.isEmpty()){
                fiw.write("");
                fiw.flush();
                return;
            }
            for (Level h:list){
                StringBuilder hh=new StringBuilder();
               // public Level(int levelNo, int strlength, int strTimes, int timeLimit, int perscrore) {
                hh.append(h.getLevelNo()).append(",");
                hh.append(h.getStrlength()).append(",");
                hh.append(h.getStrTimes()).append(",");
                hh.append(h.getTimeLimit()).append(",");
                hh.append(h.getPerscrore()).append("\n");
                fiw.write(hh.toString());
                fiw.flush();
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }finally {
            FileTool.close(fiw);
        }
    }

}

