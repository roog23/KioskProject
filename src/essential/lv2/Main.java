package essential.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List <MenuItem> menuItems = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int check;

        //MenuItem을 이용해 메뉴 각각의 객체를 생성합니다.
        MenuItem menu1 = new MenuItem("ShackBurger" , 6.9 , "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem menu2 = new MenuItem("SmokeShack" , 8.9 , "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem menu3 = new MenuItem("Cheeseburger" , 6.9 , "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem menu4 = new MenuItem("Hamburger" , 5.4 , "비프패티를 기반으로 야채가 들어간 기본버거");

        //입력된 메뉴를 list에 저장합니다.
        menuItems.add(menu1);
        menuItems.add(menu2);
        menuItems.add(menu3);
        menuItems.add(menu4);

        //종료하기 전까지 계속 반복됩니다.
        while(true){
            //저장된 메뉴를 출력해줍니다.
            for(int i = 0; i < menuItems.size(); i++){
                System.out.println((i+1) + ". " + menuItems.get(i).name + "\t| W "
                    + menuItems.get(i).price + "\t|\t"+ menuItems.get(i).ex);
            }
            System.out.println("0. 종료\t\t\t| 종료");

            //메뉴 입력을 받을 때 숫자가 아닌 경우 예외 처리 방법입니다.
            try{
                check = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("메뉴 옆에 작성된 숫자를 입력해주세요.\n");
                scanner.next();
                continue;
            }
            //0을 입력 받으면 종료시킵니다.
            if(check == 0) {
                System.out.println("\n프로그램을 종료합니다.");
                break;
            }
            //선택한 메뉴를 출력해줍니다.
            else if(check <= menuItems.size() && check > 0) {
                System.out.println("선택한 메뉴 : " + menuItems.get(check-1).name + "\t| W "
                        + menuItems.get(check-1).price + "\t|\t"+ menuItems.get(check-1).ex + "\n");
            }
            //메뉴에 지정된 숫자 이외의 입력이 들어오는 경우 처리 방법입니다.
            else {
                System.out.println("메뉴 옆에 작성된 숫자를 입력해주세요.\n");
            }
        }

    }
}
