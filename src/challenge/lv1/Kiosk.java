package challenge.lv1;

import java.util.Scanner;

public class Kiosk {
    Scanner scanner = new Scanner(System.in);
    private final Menu menu = new Menu();
    private final ShoppingCart cart = new ShoppingCart();

    public void start() {
        //종료하기 전까지 계속 반복됩니다.
        while (true) {
            //카테고리를 출력하고, 입력에 오류가 있는지 확인합니다.
            int categoryCheck = errorCheck("category");

            //0을 입력 받으면 종료시킵니다.
            if (categoryCheck == 0) {
                System.out.println("\n프로그램을 종료합니다.");
                break;
            }
            //카테고리를 설정합니다.
            else if (categoryCheck <= menu.getCategorySize() && categoryCheck > 0) {
                menu.setCategory(categoryCheck);
            }
            //장바구니 기능을 선택한 경우 실행됩니다.
            else if (cart.getCartSize() != 0 &&
                    categoryCheck > menu.getCategorySize() &&
                    categoryCheck <= menu.getCategorySize() + 2) {
                //선택한 기능 내용을 출력합니다.
                cart.Order(categoryCheck- menu.getCategorySize());
                //장바구니 확인 & 주문을 선택한 경우 실행됩니다.
                if(categoryCheck - menu.getCategorySize()==1) {
                    String calculate = scanner.next();
                    if(calculate.equals("1")){  //1을 입력받은 경우만 주문을 진행합니다.
                        System.out.println("\n주문이 완료되었습니다. 금액은 W " + cart.getTotal()+"입니다.\n");
                        cart.cartClear();
                    }
                    continue;
                }
                //주문 취소를 선택한 경우 실행됩니다.
                else if(categoryCheck - menu.getCategorySize()==2) {
                    String calculate = scanner.next();
                    if(calculate.equals("1")){  //1을 입력받은 경우만 주문 취소를 진행합니다.
                        System.out.println("모든 주문이 취소되었습니다.\n");
                        cart.cartClear();
                    }
                    continue;
                }
            }

            //메뉴 입력에 오류가 있는지 확인합니다.
            int menuCheck = errorCheck("menu");
            //0을 입력 받으면 카테고리 선택으로 돌아갑니다.
            if (menuCheck == 0) {
                System.out.println("되돌아갑니다.\n");
            }
            //선택한 메뉴를 출력해줍니다.
            else if (menuCheck <= menu.getMenuSize() && menuCheck > 0) {
                MenuItem checkMenu = menu.getMenu(menuCheck - 1);
                System.out.println("선택한 메뉴 : " + checkMenu.getName() + "\t| W "
                        + checkMenu.getPrice() + "\t|\t" + checkMenu.getEx() + "\n");

                cart.cartAddCheck(checkMenu);   //장바구니에 담을지 확인해줍니다.

                if (scanner.next().equals("1")) //1을 입력받은 경우 장바구니에 추가합니다.
                    cart.setCart(checkMenu);
                else                            //이외 입력은 장바구니에 추가하지 않습니다.
                    System.out.println("장바구니에 추가되지 않았습니다.\n");
            }
        }
    }
    //목록을 출력하고, 입력 오류를 확인하는 기능을 합니다.
    public int errorCheck(String list) {
        int check;
        //입력에 오류가 없을 때 까지 반복합니다.
        while(true) {
            //카테고리 목록을 출력해줍니다.
            if(list.equals("category")) {
                menu.printCategory();
                if (cart.getCartSize() != 0) {
                    cart.printOrder(menu.getCategorySize());
                }
            }
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
            if(list.equals("category")) {
                if (cart.getCartSize() == 0 &&  // 장바구니에 메뉴가 없는 경우 처리 방식입니다.
                        (check > menu.getCategorySize() || check < 0)) {
                    System.out.println("카테고리 옆에 작성된 숫자를 입력해주세요.\n");
                    continue;
                }
                else if (cart.getCartSize() != 0 && //장바구니에 메뉴가 있는 경우 처리 방식입니다.
                        (check > menu.getCategorySize() + 2 || check < 0)) {
                    System.out.println("카테고리 옆에 작성된 숫자를 입력해주세요.\n");
                    continue;
                }
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

