package student.enty;

import java.util.List;

public class Teacher {
    private int id;//老师编号
    private String name;//姓名
    private int kemid;//所授专业编号

    public Teacher() {
    }

    public Teacher(int id, String name, int kemid) {
        this.id = id;
        this.name = name;
        this.kemid = kemid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKemid() {
        return kemid;
    }

    public void setKemid(int kemid) {
        this.kemid = kemid;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kemid='" + kemid + '\'' +
                '}';
    }
}
