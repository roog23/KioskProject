package essential.lv5;

import java.util.Scanner;

public class Kiosk {
    private final Scanner scanner = new Scanner(System.in);
    private final Menu menu = new Menu();

    public void start() {
        //종료하기 전까지 계속 반복됩니다.
        while(true){
            //카테고리 입력에 오류가 있는지 확인합니다.
            int categoryCheck = errorCheck("category");

            //0을 입력 받으면 종료시킵니다.
            if(categoryCheck == 0) {
                System.out.println("\n프로그램을 종료합니다.");
                break;
            }
            //카테고리를 설정합니다.
            else if (categoryCheck <= menu.getCategorySize() && categoryCheck > 0) {
                menu.setCategory(categoryCheck);
            }

            //메뉴 입력에 오류가 있는지 확인합니다.
            int menuCheck = errorCheck("menu");

            //0을 입력 받으면 카테고리 선택으로 돌아갑니다.
            if(menuCheck ==0){
                 System.out.println("되돌아갑니다.\n");
             }
            //선택한 메뉴를 출력해줍니다.
            else if(menuCheck <= menu.getMenuSize() && menuCheck > 0) {
                 MenuItem checkMenu = menu.getMenu(menuCheck -1);
                 System.out.println("선택한 메뉴 : " + checkMenu.getName() + "\t| W "
                         + checkMenu.getPrice() + "\t|\t"+ checkMenu.getEx()+"\n");

             }
        }
    }

    //입력 오류를 확인하는 기능을 합니다.
    public int errorCheck(String list) {
        int check;
        //입력에 오류가 없을 때 까지 반복합니다.
        while(true) {
            if(list.equals("category"))  menu.printCategory();   //메뉴의 카테고리 목록을 출력해줍니다.
            else if (list.equals("menu")) menu.printMenu(); //메뉴 목록을 출력해줍니다.

            //입력을 받을 때 숫자가 아닌 경우 예외 처리 방법입니다.
            try {
                check = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("옆에 작성된 숫자를 입력해주세요.\n");
                scanner.next();
                continue;
            }

            //카테고리에 지정된 숫자 외의 입력이 들어오는 경우 처리 방법입니다.
            if(list.equals("category") && (check > menu.getCategorySize() || check < 0)){
                System.out.println("카테고리 옆에 작성된 숫자를 입력해주세요.\n");
                continue;
            }

            //메뉴에 지정된 숫자 외의 입력이 들어오는 경우 처리 방법입니다.
            if(list.equals("menu") && (check > menu.getMenuSize() || check < 0)){
                System.out.println("메뉴 옆에 작성된 숫자를 입력해주세요.");
                continue;
            }

            break;
        }
        return check;
    }
}
