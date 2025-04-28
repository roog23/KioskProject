package essential.lv2;

public class MenuItem {
    public String name;
    public double price;
    public String ex;

    //메뉴가 가지고 있어야 하는 항목을 관리합니다.
    public MenuItem(String name, double price, String ex){
        this.name = name;
        this.price = price;
        this.ex = ex;
    }

}
