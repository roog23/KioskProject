package Challenge.Lv1;

import java.util.Scanner;

public class Kiosk {
    Scanner scanner = new Scanner(System.in);
    private final Menu menu = new Menu();
    private final ShoppingCart cart = new ShoppingCart();

    public void start() {

        while (true) {
            int categoryCheck;
            String category = "";
            menu.printCategory();
            if (cart.getCartSize() != 0) {
                cart.printOrder(menu.getCategorySize());
            }

            try {
                categoryCheck = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다.\n");
                scanner.next();
                continue;
            }
            if (categoryCheck == 0) {
                System.out.println("\n프로그램을 종료합니다.");
                break;
            }
            else if (categoryCheck <= menu.getCategorySize() && categoryCheck > 0) {
                category = menu.getCategory(categoryCheck);
            }
            else if (cart.getCartSize() != 0 &&
                    categoryCheck > menu.getCategorySize() &&
                    categoryCheck <= menu.getCategorySize() + 2) {
                cart.Order(categoryCheck- menu.getCategorySize());
                if(categoryCheck- menu.getCategorySize()==1) {
                    String calculate = scanner.next();
                    if(calculate.equals("1")){
                        System.out.println("\n주문이 완료되었습니다. 금액은 W " + cart.getTotal()+"입니다.\n");
                        cart.cartClear();
                    }
                }
                else if(categoryCheck- menu.getCategorySize()==2) {
                    String calculate = scanner.next();
                    if(calculate.equals("1")){
                        System.out.println("모든 주문이 취소되었습니다.");
                        cart.cartClear();
                    }
                }
            }
            else {
                System.out.println("잘못된 입력입니다.\n");
                continue;
            }

            if (categoryCheck <= menu.getCategorySize() && categoryCheck > 0) {
                while (true) {
                    menu.printMenu(category);

                    int menuCheck;
                    try {
                        menuCheck = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("잘못된 입력입니다.");
                        scanner.next();
                        continue;
                    }

                    if (menuCheck == 0) {
                        System.out.println("되돌아갑니다.\n");
                        break;
                    } else if (menuCheck <= menu.getMenuSize() && menuCheck > 0) {
                        MenuItem checkMenu = menu.getMenu(menuCheck - 1);
                        System.out.println("선택한 메뉴 : " + checkMenu.getName() + "\t| W "
                                + checkMenu.getPrice() + "\t|\t" + checkMenu.getEx() + "\n");

                        cart.cartAddCheck(checkMenu);
                        if (scanner.next().equals("1"))
                            cart.setCart(checkMenu);
                        else
                            System.out.println("장바구니에 추가되지 않았습니다.\n");

                        break;
                    } else {
                        System.out.println("잘못된 입력입니다.");
                    }
                }
            }
        }

    }
}

