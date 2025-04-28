package essential.lv4;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    String[] categoryList = {"Burgers", "Drinks", "Desserts"};
    String category;
    List<MenuItem> menuBurgers = new ArrayList<>();
    List<MenuItem> menuDrinks = new ArrayList<>();
    List<MenuItem> menuDesserts = new ArrayList<>();

    //메뉴를 생성하고 메뉴의 카테고리 리스트에 메뉴를 등록하는 기능을 합니다.
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

    //메뉴의 카테고리를 출력해주는 기능입니다.
    public void printCategory() {
        System.out.println("[ MAIN MENU ]");
        for(int j=0; j < categoryList.length; j++){
            System.out.println((j+1) + ". " + categoryList[j]);
        }
        System.out.println("0. 종료\t\t|종료");
    }

    //카테고리를 설정하는 기능입니다.
    public void setCategory(int num) {
        category = categoryList[num-1];
    }

    //카테고리의 크기를 반환해주는 기능입니다.
    public int getCategorySize() {
        return categoryList.length;
    }

    //카테고리의 메뉴를 출력해주는 기능입니다.
    public void printMenu() {
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

    //저장된 메뉴 리스트의 크기를 반환하는 기능입니다.
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

    //선택한 메뉴를 반환하는 기능입니다.
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
