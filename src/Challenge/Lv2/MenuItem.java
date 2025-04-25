package Challenge.Lv2;

public class MenuItem {
    private final String name;
    private final double price;
    private final String ex;

    public MenuItem(String name, double price, String ex){
        this.name = name;
        this.price = price;
        this.ex = ex;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getEx() {
        return ex;
    }
}
