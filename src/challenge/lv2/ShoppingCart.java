package challenge.lv2;

import java.util.*;

public class ShoppingCart {
    private final Map<MenuItem,Integer> cart = new HashMap<>();
    private double total;

    public int getCartSize() {
        return cart.size();
    }

    public void cartAddCheck(MenuItem shopping) {
        System.out.println(shopping.getName()+"\t | W "+shopping.getPrice()+"\t|\t"+ shopping.getEx());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인 \t2. 취소");
    }

    public void setCart(MenuItem shopping) {
        cart.put(shopping,cart.getOrDefault(shopping,0)+1);
        System.out.println(shopping.getName()+"이 장바구니에 추가되었습니다.\n");
    }

    public void printOrder(int size) {
        System.out.println("\n[ ORDER MENU ]");
        System.out.println((size+1) + ". Orders \t|장바구니를 확인 후 주문합니다.");
        System.out.println((size+2) + ". Cancel \t|진행중인 주문을 취소합니다.");
        System.out.println((size+3) + ". CartList |장바구니 리스트를 확인합니다.");
    }

    public void Order(int order){
        if(order == 1) {
            total = 0;
            System.out.println("아래와 같이 주문 하시겠습니까?\n");
            System.out.println("[ Orders ]");
            for(MenuItem menu : cart.keySet()) {
                System.out.println("- "+menu.getName()+"\t| W "+menu.getPrice()+"\t|\t"+ cart.get(menu));
                total += (menu.getPrice() * cart.get(menu));
            }
            System.out.println("\n[ Total ]");
            System.out.println("W " + total);
            System.out.println("\n1. 주문 \t 2.메뉴판");
        }
        else if(order == 2) {
            System.out.println("모든 주문을 취소하시겠습니까?");
            System.out.println("1. 모든 주문 취소 \t 2.되돌리기");
        }
        else if(order == 3) {
            System.out.println("\n[ Cart List ]");
            int[] number = {1};
            cart.forEach((menu, quantity) -> System.out.println(number[0]++ + ". "+menu.getName()+"\t| W "+menu.getPrice()+"\t|\t"+ quantity));
            System.out.println("주문을 취소하시겠습니까?");
            System.out.println("1. 주문 취소 \t 2.되돌리기");
        }
    }

    public void cartClear() {
        cart.clear();
    }

    public double getTotal() {
        return total;
    }

    public void cartRemove(int number){
        int[] check = {1};
        List<MenuItem> menuItem = cart.entrySet().stream()
                .filter(a->check[0]++ == number)
                .map(menu -> menu.getKey())
                .toList();
        System.out.println(menuItem.getFirst().getName());

        cart.remove(menuItem.getFirst());
    }
}