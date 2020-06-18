package student.dao;

import cheeat.util.FileTools;
import student.enty.Kmenu;
import student.enty.SteToTeach;
import student.enty.Stuedent;
import student.enty.Teacher;
import yuoxi.filetool.FileTool;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements Dao{
    public static final String DIR1 ="f:\\yy\\student.txt";//存放学生信息
    public static final String DIR2 ="f:\\yy\\teacher.txt";//存放老师
    public static final String DIR3 ="f:\\yy\\kmenu.txt";//专业
    public static final String DIR4 ="f:\\yy\\StetoTeach.txt";//关系文件


    @Override
    public void addStudent(List< Stuedent > list) {
        //新增学生信息
        FileWriter fw=null;
        try {
            fw=new FileWriter( DIR1 ,true);
            if (list.isEmpty()){
                fw.write( "" );
                fw.flush();
                return ;
            }
            for (Stuedent ss:list ){
                StringBuilder st=new StringBuilder(  );
                st.append( ss.getId() ).append( "," );
                st.append( ss.getName() ).append( "," );
                st.append( ss.getSex()).append( "," );
                st.append( ss.getAge()).append( "\n" );
                fw.write(st.toString());
                fw.flush();
            }
        } catch (IOException e) {
          throw new RuntimeException( e );
        }finally {
            FileTools.close(fw);
        }
    }

    @Override
    public void addTeacher(List< Teacher > list) {
        //新增老师信息
        FileWriter fw=null;
        try {
            fw=new FileWriter( DIR2 ,true);
            if (list.isEmpty()){
                fw.write( "" );
                fw.flush();
                return;
            }
            for (Teacher ss:list ){
                StringBuilder st=new StringBuilder(  );
                st.append( ss.getId() ).append( "," );
                st.append( ss.getName() ).append( "," );
                st.append( ss.getKemid()).append( "\n" );
                fw.write(st.toString());
                fw.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException( e );
        }finally {
            FileTools.close(fw);
        }
    }

    @Override
    public void addKmenu(List< Kmenu > list) {
        //新增专业
        FileWriter fw=null;
        try {
            fw=new FileWriter( DIR3 ,true);
            if (list.isEmpty()){
                fw.write( "" );
                fw.flush();
                return;
            }
            for (Kmenu ss:list ){
                StringBuilder st1=new StringBuilder(  );
                st1.append( ss.getKmenuid() ).append( "," );
                st1.append( ss.getKmenuName()).append( "\n" );
                fw.write(st1.toString());
                fw.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException( e );
        }finally {
            FileTools.close(fw);
        }
    }
    public List< Stuedent > queyStudent(){
        //查询学生信息
            FileReader fr=null;//读取文件
            BufferedReader bw=null;//写入文件
            List< Stuedent > list=new ArrayList<>();//创建集合装内容
            try {
                fr=new FileReader(DIR1);//找到文件
                bw=new BufferedReader(fr);//拿出内容
                String str=null;//设置一个字符变量
                while ((str=bw.readLine())!=null){
                    Stuedent st=new Stuedent();
                    String []jj=str.split( "," );
                    st.setId(Integer.parseInt( jj[0] ));
                    st.setName(jj[1]);
                    st.setSex( jj[2] );
                    st.setAge( jj[3] );
                    list.add( st );
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                FileTools.close(fr);
                FileTool.close(bw);
            }return list;
        }

    @Override
    public List< Teacher > queyTeacher(){
        //查询老师表
            FileReader fr=null;//读取文件
            BufferedReader bw=null;//写入文件
            List< Teacher > list1=new ArrayList<>();//创建集合装内容
            try {
                fr=new FileReader(DIR2);//找到文件
                bw=new BufferedReader(fr);//拿出内容
                String str=null;//设置一个字符变量
                while ((str=bw.readLine())!=null){
                    Teacher st=new Teacher();
                    String []jj=str.split( "," );
                    st.setId(Integer.parseInt(jj[0]));
                    st.setName(jj[1]);
                    st.setKemid( Integer.parseInt(jj[2] ) );
                    list1.add( st );
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                FileTools.close(fr);
                FileTool.close(bw);
            }return list1;
        }

        @Override
    public List< Kmenu > queyKmenu() {//
                FileReader fr=null;//读取文件
                BufferedReader bw=null;//写入文件
                List< Kmenu > list2=new ArrayList<>();//创建集合装内容
                try {
                    fr=new FileReader(DIR3);//找到文件
                    bw=new BufferedReader(fr);//拿出内容
                    String str=null;//设置一个字符变量
                    while ((str=bw.readLine())!=null){
                        Kmenu st=new Kmenu();
                        String []jj=str.split( "," );
                        st.setKmenuid(Integer.parseInt(jj[0]));
                        st.setKmenuName(( jj[1] ));
                        list2.add(st);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }finally {
                    FileTools.close(fr);
                    FileTool.close(bw);
                }return list2;
            }

    @Override
    public void addeStetoTeach(List< SteToTeach > list) {
        FileWriter fw=null;
        try {
            fw=new FileWriter( DIR4 ,true);
            if (list.isEmpty()){
                fw.write( "" );
                fw.flush();
                return;
            }
            for (SteToTeach ss:list ){
                StringBuilder st1=new StringBuilder(  );
                st1.append( ss.getTeachid() ).append( "," );
                st1.append( ss.getStudentid()).append( "\n" );
                fw.write(st1.toString());
                fw.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException( e );
        }finally {
            FileTool.close( fw );
    }

    }

    @Override
    public List< SteToTeach > queySteToTeach() {
        FileReader fr=null;//读取文件
        BufferedReader bw=null;//写入文件
        List< SteToTeach > list2=new ArrayList<>();//创建集合装内容
        try {
            fr=new FileReader(DIR4);//找到文件
            bw=new BufferedReader(fr);//拿出内容
            String str=null;//设置一个字符变量
            while ((str=bw.readLine())!=null){
                SteToTeach st=new SteToTeach();
                String []jj=str.split( "," );
                st.setStudentid(Integer.parseInt(jj[0]));
                st.setTeachid(Integer.parseInt( jj[1] ));
                list2.add(st);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            FileTools.close(fr);
            FileTool.close(bw);
        }return list2;
    }

}
