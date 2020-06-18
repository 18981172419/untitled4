package cheeat.enty;
//菜谱
public class Dish {
    private String name;//菜名
    private double price;//价格
    private int click;//点赞

    public Dish() {
    }

    public Dish(String name, double price, int click) {
        this.name = name;
        this.price = price;
        this.click = click;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", click=" + click +
                '}';
    }
}
