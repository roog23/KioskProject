package challenge.lv1;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final Map<MenuItem,Integer> cart = new HashMap<>();
    private double total;

    // 장바구니의 크기를 반환해줍니다.
    public int getCartSize() {
        return cart.size();
    }

    // 장바구니에 담을지 확인하는 기능을 합니다.
    public void cartAddCheck(MenuItem shopping) {
        System.out.println(shopping.getName()+"\t | W "+shopping.getPrice()+"\t|\t"+ shopping.getEx());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인 \t2. 취소");
    }

    // 장바구니에 추가하는 기능을 합니다.
    public void setCart(MenuItem shopping) {
        cart.put(shopping,cart.getOrDefault(shopping,0)+1);
        System.out.println(shopping.getName()+"이 장바구니에 추가되었습니다.\n");
    }

    // 장바구니 기능을 출력해줍니다.
    public void printOrder(int size) {
        System.out.println("\n[ ORDER MENU ]");
        System.out.println((size+1) + ". Orders \t|장바구니를 확인 후 주문합니다.");
        System.out.println((size+2) + ". Cancel \t|진행중인 주문을 취소합니다.");
    }

    //장바구니 기능 진행을 안내하는 역할을 합니다.
    public void Order(int order){
        if(order == 1) {    //장바구니 주문 기능을 수행합니다.
            total = 0;
            System.out.println("아래와 같이 주문 하시겠습니까?\n");
            System.out.println("[ Orders ]");
            for(MenuItem menu : cart.keySet()) {    //장바구니에 담은 메뉴를 모두 출력해줍니다.
                System.out.println("- "+menu.getName()+"\t| W "+menu.getPrice()+"\t|\t"+ cart.get(menu));
                total += (menu.getPrice() * cart.get(menu));    //메뉴의 총합을 계산해줍니다.
            }
            System.out.println("\n[ Total ]");
            System.out.println("W " + total);
            System.out.println("\n1. 주문 \t 2.메뉴판");
        }
        if(order == 2) {    //장바구니 취소 기능을 수행합니다.
            System.out.println("모든 주문을 취소하시겠습니까?");
            System.out.println("1. 모든 주문 취소 \t 2.되돌리기");
        }
    }

    //장바구니를 초기화 시켜줍니다.
    public void cartClear() {
        cart.clear();
    }
    //장바구니에 담은 메뉴의 총 합을 반환해줍니다.
    public double getTotal() {
        return total;
    }
}