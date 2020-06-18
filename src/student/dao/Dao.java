package student.dao;

import student.enty.Kmenu;
import student.enty.SteToTeach;
import student.enty.Stuedent;
import student.enty.Teacher;

import java.util.List;

public interface Dao {
    public void addStudent(List<Stuedent> list);//新增学生信息
    public void addTeacher(List<Teacher> list);//新增老师信息
    public void addKmenu(List< Kmenu > list);//新增专业
    public List< Stuedent > queyStudent();//查询所有student学生信息
    public List< Teacher > queyTeacher() ;//查询所有老师信息
    public List< Kmenu > queyKmenu() ;//查询所有专业信息
    public void addeStetoTeach(List<SteToTeach> list);//添加关系文件
    public List<SteToTeach> queySteToTeach();//查询关系文件
}
