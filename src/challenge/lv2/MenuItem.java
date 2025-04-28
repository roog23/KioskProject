package challenge.lv2;

public class MenuItem {
    private final String name;
    private final double price;
    private final String ex;

    //메뉴가 가지고 있어야 하는 항목을 관리합니다.
    public MenuItem(String name, double price, String ex){
        this.name = name;
        this.price = price;
        this.ex = ex;
    }

    //메뉴 이름을 반환해줍니다.
    public String getName() {
        return name;
    }
    //메뉴 가격을 반환해줍니다.
    public double getPrice() {
        return price;
    }
    //메뉴 설명을 반환해줍니다.
    public String getEx() {
        return ex;
    }
}
