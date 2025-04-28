package essential.lv1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int check;
        String[] menuName = { " " , "ShackBurger" , "SmokeShack" , "Cheeseburger" , "Hamburger" };
        double[] menuPrice = { 0 , 6.9 , 8.9 , 6.9 , 5.4 };
        String[] menuEx = { " " , "토마토, 양상추, 쉑소스가 토핑된 치즈버거" , "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거" , "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거" , "비프패티를 기반으로 야채가 들어간 기본버거" };

        //종료하기 전까지 계속 반복됩니다.
        while(true) {
            //저장된 메뉴를 출력해줍니다.
            for (int i = 1; i < menuName.length; i++) {
                System.out.println(i + ". " + menuName[i] + "\t| W " + menuPrice[i] + "\t|\t" + menuEx[i]);
            }
            System.out.println("0. 종료\t\t\t| 종료");

            //메뉴 입력을 받을 때 숫자가 아닌 경우 예외 처리 방법입니다.
            try {
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
            else if(check < menuName.length && check > 0) {
                System.out.println("선택한 메뉴 : " + menuName[check] + "\t| W " + menuPrice[check] + "\t|\t "+ menuEx[check] + "\n");
            }
            //메뉴에 지정된 숫자 이외의 입력이 들어오는 경우 처리 방법입니다.
            else {
                System.out.println("메뉴 옆에 작성된 숫자를 입력해주세요.\n");
            }
        }

    }
}
