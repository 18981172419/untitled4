package cheeat.enty;
//订单管理类
public class Order {
    private int orderNo;//订单编号
    private String eator;//吃货姓名
    private String name;//菜名
    private  int amount;//份数
    private int time;//点餐时间
    private String address;//地址
    private int status;//0:没有签收 1：签收
    private double totalPrice;//总价

    public Order() {
    }

    public Order(int orderNo, String eator, String name, int amount, String address, int status, double totalPrice) {
        this.orderNo = orderNo;
        this.eator = eator;
        this.name = name;
        this.amount = amount;
        this.time = time;
        this.address = address;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public String getEator() {
        return eator;
    }

    public void setEator(String eator) {
        this.eator = eator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo=" + orderNo +
                ", eator='" + eator + '\'' +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", time=" + time +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
