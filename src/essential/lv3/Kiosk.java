package essential.lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<MenuItem> menuItems = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    int check;

    public void setMenuItems(MenuItem menuItems) {
        this.menuItems.add(menuItems);
    }

    public void printMenu() {
        for(int i = 0; i < menuItems.size(); i++){
            System.out.println((i+1) + ". " + menuItems.get(i).name + "\t| W "
                    + menuItems.get(i).price + "\t|\t"+ menuItems.get(i).ex);
        }
        System.out.println("0. 종료\t\t\t| 종료");
    }

    public void start() {
        while(true){

            printMenu();

            try{
                check = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다.\n");
                scanner.next();
                continue;
            }

            if(check == 0) {
                System.out.println("\n프로그램을 종료합니다.");
                break;
            }
            else if(check <= menuItems.size() && check > 0) {
                System.out.println("선택한 메뉴 : " + menuItems.get(check -1).name + "\t| W "
                        + menuItems.get(check -1).price + "\t|\t"+ menuItems.get(check -1).ex + "\n");
            }
            else {
                System.out.println("잘못된 입력입니다.\n");
            }
        }
    }
}
