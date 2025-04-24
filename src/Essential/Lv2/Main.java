package Essential.Lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List <MenuItem> menuItems = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int check;

        MenuItem menu1 = new MenuItem("ShackBurger" , 6.9 , "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem menu2 = new MenuItem("SmokeShack" , 8.9 , "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem menu3 = new MenuItem("Cheeseburger" , 6.9 , "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem menu4 = new MenuItem("Hamburger" , 5.4 , "비프패티를 기반으로 야채가 들어간 기본버거");

        menuItems.add(menu1);
        menuItems.add(menu2);
        menuItems.add(menu3);
        menuItems.add(menu4);

        while(true){
            for(int i = 0; i < menuItems.size(); i++){
                System.out.println((i+1) + ". " + menuItems.get(i).name + "\t| W "
                    + menuItems.get(i).price + "\t|\t"+ menuItems.get(i).ex);
            }

            System.out.println("0. 종료\t\t\t| 종료");

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
                System.out.println("선택한 메뉴 : " + menuItems.get(check-1).name + "\t| W "
                        + menuItems.get(check-1).price + "\t|\t"+ menuItems.get(check-1).ex + "\n");
            }
            else {
                System.out.println("잘못된 입력입니다.\n");
            }
        }

    }
}
