package essential.lv4;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    String[] categoryList = {"Burgers", "Drinks", "Desserts"};
    String category;
    List<MenuItem> menuBurgers = new ArrayList<>();
    List<MenuItem> menuDrinks = new ArrayList<>();
    List<MenuItem> menuDesserts = new ArrayList<>();

    public Menu(){
        MenuItem burger1 = new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem burger2 = new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem burger3 = new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem burger4 = new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");

        this.menuBurgers.add(burger1);
        this.menuBurgers.add(burger2);
        this.menuBurgers.add(burger3);
        this.menuBurgers.add(burger4);

        MenuItem drink1 = new MenuItem("Coke", 1.5, "콜라");

        this.menuDrinks.add(drink1);

        MenuItem dessert1 = new MenuItem("IceCream", 2.5, "아이스크림");

        this.menuDesserts.add(dessert1);
    }
    public void printCategory() {
        System.out.println("[ MAIN MENU ]");
        for(int j=0; j < categoryList.length; j++){
            System.out.println((j+1) + ". " + categoryList[j]);
        }
        System.out.println("0. 종료\t\t|종료");
    }

    public String getCategory(int num) {
        category = categoryList[num-1];
        return category;
    }

    public int getCategorySize() {
        return categoryList.length;
    }

    public void printMenu(String category) {
        System.out.println("\n[ " + category + " MENU ]");
        switch (category) {
            case "Burgers" -> {
                for(int i = 0; i < menuBurgers.size(); i++){
                    System.out.println((i+1) + ". " + menuBurgers.get(i).name + "\t| W "
                            + menuBurgers.get(i).price + "\t|\t"+ menuBurgers.get(i).ex);
                }
            }
            case "Drinks" -> {
                for(int i = 0; i < menuDrinks.size(); i++){
                    System.out.println((i+1) + ". " + menuDrinks.get(i).name + "\t| W "
                            + menuDrinks.get(i).price + "\t|\t"+ menuDrinks.get(i).ex);
                }
            }
            case "Desserts" -> {
                for(int i = 0; i < menuDesserts.size(); i++){
                    System.out.println((i+1) + ". " + menuDesserts.get(i).name + "\t| W "
                            + menuDesserts.get(i).price + "\t|\t"+ menuDesserts.get(i).ex);
                }
            }
        }
        System.out.println("0. 뒤로가기");

    }

    public int getMenuSize() {
        switch (category) {
            case "Burgers" -> {
                return menuBurgers.size();
            }
            case "Drinks" -> {
                return menuDrinks.size();
            }
            case "Desserts" -> {
                return menuDesserts.size();
            }
        }
        return 0;
    }

    public MenuItem getMenu(int i) {
        switch (category) {
            case "Burgers" -> {
                return menuBurgers.get(i);
            }
            case "Drinks" -> {
                return menuDrinks.get(i);
            }
            case "Desserts" -> {
                return menuDesserts.get(i);
            }
        }
        return null;
    }
}
