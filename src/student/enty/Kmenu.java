package student.enty;

public class Kmenu {
    private int kmenuid;
    private String kmenuName;

    public Kmenu(int kmenuid, String kmenuName) {
        this.kmenuid = kmenuid;
        this.kmenuName = kmenuName;
    }

    public Kmenu() {
    }

    public int getKmenuid() {
        return kmenuid;
    }

    public void setKmenuid(int kmenuid) {
        this.kmenuid = kmenuid;
    }

    public String getKmenuName() {
        return kmenuName;
    }

    public void setKmenuName(String kmenuName) {
        this.kmenuName = kmenuName;
    }

    @Override
    public String toString() {
        return "Kmenu{" +
                "kmenuid=" + kmenuid +
                ", kmenuName='" + kmenuName + '\'' +
                '}';
    }
}
