package essential.lv5;

import java.util.Scanner;

public class Kiosk {
    Scanner scanner = new Scanner(System.in);
    private final Menu menu = new Menu();

    public void start() {

        while(true){
            String category;
            menu.printCategory();
            int categoryCheck;
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

            while(true){
                menu.printMenu(category);

                int menuCheck;
                try{
                    menuCheck = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("잘못된 입력입니다.");
                    scanner.next();
                    continue;
                }

                if(menuCheck ==0){
                    System.out.println("되돌아갑니다.\n");
                    break;
                }
                else if(menuCheck <= menu.getMenuSize() && menuCheck > 0) {
                    MenuItem checkMenu = menu.getMenu(menuCheck -1);
                    System.out.println("선택한 메뉴 : " + checkMenu.getName() + "\t| W "
                        + checkMenu.getPrice() + "\t|\t"+ checkMenu.getEx()+"\n");
                    break;
                }
                else {
                    System.out.println("잘못된 입력입니다.");
                }
            }
        }

    }
}
