package essential.lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<MenuItem> menuItems = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    int check;

    //키오스크에 메뉴를 등록하는 기능을 합니다.
    public void setMenuItems(MenuItem menuItems) {
        this.menuItems.add(menuItems);
    }

    //키오스크의 메뉴를 출력해주는 기능을 합니다.
    public void printMenu() {
        for(int i = 0; i < menuItems.size(); i++){
            System.out.println((i+1) + ". " + menuItems.get(i).name + "\t| W "
                    + menuItems.get(i).price + "\t|\t"+ menuItems.get(i).ex);
        }
        System.out.println("0. 종료\t\t\t| 종료");
    }

    //키오스크를 실행시킵니다.
    public void start() {
        //종료하기 전까지 계속 반복됩니다.
        while(true){

            printMenu();
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
                System.out.println("선택한 메뉴 : " + menuItems.get(check -1).name + "\t| W "
                        + menuItems.get(check -1).price + "\t|\t"+ menuItems.get(check -1).ex + "\n");
            }
            //메뉴에 지정된 숫자 이외의 입력이 들어오는 경우 처리 방법입니다.
            else {
                System.out.println("메뉴 옆에 작성된 숫자를 입력해주세요.\n");
            }
        }
    }
}
