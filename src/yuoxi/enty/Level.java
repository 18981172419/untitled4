package yuoxi.enty;

public class Level {
    private int levelNo;//级别号
    private int strlength;//各级别一次输出的字符串的长度
    private int strTimes;//输出字符串的次数
    private int timeLimit;//闯关的时间限制
    private int perscrore;//输入一次的得分

    public Level() {
    }

    public Level(int levelNo, int strlength, int strTimes, int timeLimit, int perscrore) {
        this.levelNo = levelNo;
        this.strlength = strlength;
        this.strTimes = strTimes;
        this.timeLimit = timeLimit;
        this.perscrore = perscrore;
    }

    public int getLevelNo() {
        return levelNo;
    }

    public void setLevelNo(int levelNo) {
        this.levelNo = levelNo;
    }

    public int getStrlength() {
        return strlength;
    }

    public void setStrlength(int strlength) {
        this.strlength = strlength;
    }

    public int getStrTimes() {
        return strTimes;
    }

    public void setStrTimes(int strTimes) {
        this.strTimes = strTimes;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public int getPerscrore() {
        return perscrore;
    }

    public void setPerscrore(int perscrore) {
        this.perscrore = perscrore;
    }

    @Override
    public String toString() {
        return "当前级别信息{" +
                "当前级别=" + levelNo +
                ", 字符串长度=" + strlength +
                ", 字符串次数=" + strTimes +
                ", 闯关时间限制=" + timeLimit +
                ", 输入一次得分=" + perscrore +
                '}';
    }
}
