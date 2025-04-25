package essential.lv3;

public class Main {
    public static void main(String[] arg) {
        Kiosk kiosk = new Kiosk();

        MenuItem menu1 = new MenuItem("ShackBurger" , 6.9 , "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem menu2 = new MenuItem("SmokeShack" , 8.9 , "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem menu3 = new MenuItem("Cheeseburger" , 6.9 , "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem menu4 = new MenuItem("Hamburger" , 5.4 , "비프패티를 기반으로 야채가 들어간 기본버거");

        kiosk.setMenuItems(menu1);
        kiosk.setMenuItems(menu2);
        kiosk.setMenuItems(menu3);
        kiosk.setMenuItems(menu4);

        kiosk.start();
    }
}
