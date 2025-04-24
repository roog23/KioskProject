package Essential.Lv1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int check;
        String[] menuName = { " " , "ShackBurger" , "SmokeShack" , "Cheeseburger" , "Hamburger" };
        double[] menuPrice = { 0 , 6.9 , 8.9 , 6.9 , 5.4 };
        String[] menuEx = { " " , "토마토, 양상추, 쉑소스가 토핑된 치즈버거" , "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거" , "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거" , "비프패티를 기반으로 야채가 들어간 기본버거" };

        while(true) {
            for (int i = 1; i < menuName.length; i++) {
                System.out.println(i + ". " + menuName[i] + "\t| W " + menuPrice[i] + "\t|\t" + menuEx[i]);
            }
            System.out.println("0. 종료\t\t\t| 종료");

            try {
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
            else if(check < menuName.length && check > 0) {
                System.out.println("선택한 메뉴 : " + menuName[check] + "\t| W " + menuPrice[check] + "\t|\t "+ menuEx[check] + "\n");
            }
            else {
                System.out.println("잘못된 입력입니다.\n");
            }
        }

    }
}
