package student.enty;

public class SteToTeach {
    private int studentid;//学生ID
    private int teachid;//老师id

    public SteToTeach(int studentid, int teachid) {
        this.studentid = studentid;
        this.teachid = teachid;
    }

    public SteToTeach() {
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getTeachid() {
        return teachid;
    }

    public void setTeachid(int teachid) {
        this.teachid = teachid;
    }

    @Override
    public String toString() {
        return "SteToTeach{" +
                "studentid=" + studentid +
                ", teachid=" + teachid +
                '}';
    }
}
