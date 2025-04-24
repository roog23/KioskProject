package Essential.Lv4;

import java.util.Scanner;

public class Kiosk {
    Scanner scanner = new Scanner(System.in);
    Menu menu = new Menu();
    String category;
    int categoryCheck , menuCheck;
    public void start() {

        while(true){
            menu.printCategory();
            try{
                categoryCheck = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다.\n");
                scanner.next();
                continue;
            }
            if(categoryCheck == 0) {
                System.out.println("\n프로그램을 종료합니다.");
                break;
            }
            else if (categoryCheck <= menu.getCategorySize() && categoryCheck > 0) {
                category = menu.getCategory(categoryCheck);
            }
            else {
                System.out.println("잘못된 입력입니다.\n");
                continue;
            }

            category = menu.getCategory(categoryCheck);

            while(true){
                menu.printMenu(category);

                try{
                    menuCheck = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("잘못된 입력입니다.");
                    scanner.next();
                    continue;
                }

                if(menuCheck==0){
                    System.out.println("되돌아갑니다.\n");
                    break;
                }
                else if(menuCheck <= menu.getMenuSize() && menuCheck > 0) {
                    MenuItem checkMenu = menu.getMenu(menuCheck-1);
                    System.out.println("선택한 메뉴 : " + checkMenu.name + "\t| W "
                        + checkMenu.price + "\t|\t"+ checkMenu.ex+"\n");
                    break;
                }
                else {
                    System.out.println("잘못된 입력입니다.");
                }
            }
        }

    }
}
