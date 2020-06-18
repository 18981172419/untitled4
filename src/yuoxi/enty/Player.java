package yuoxi.enty;

public class Player {
    private int id;
    private int levelNo=1 ;//级别
    private  int currScrore;//当前积分
    private long startTime=System.currentTimeMillis();//当前开始时间
    private int elapsedTime ;//当前级别已用时间
    private String pass;//密码
    private String user;//用户名

    public Player() {
    }

    public Player(int id, int levelNo, int currScrore, long startTime, int elapsedTime, String pass, String user) {
        this.id = id;
        this.levelNo = levelNo;
        this.currScrore = currScrore;
        this.startTime = startTime;
        this.elapsedTime = elapsedTime;
        this.pass = pass;
        this.user = user;
    }

    public Player(int id,String pass, String user) {
        this.pass = pass;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevelNo() {
        return levelNo;
    }

    public void setLevelNo(int levelNo) {
        this.levelNo = levelNo;
    }

    public int getCurrScrore() {
        return currScrore;
    }

    public void setCurrScrore(int currScrore) {
        this.currScrore = currScrore;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public int getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(int elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "玩家{" +
                "id号=" + id +
                ", 级别=" + levelNo +
                ", 当前积分=" + currScrore +
                ", 开始时间=" + startTime +
                ", 当前级别已用时间=" + elapsedTime +
                ", 密码='" + pass + '\'' +
                ", 用户名='" + user + '\'' +
                '}';
    }
}
