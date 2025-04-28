package challenge.lv2;

public enum SaleInfo {
    국가유공자(1,10),
    군인(2,5),
    학생(3,3),
    일반(4,0);

    private final int number;
    private final double saleRate;

    //세일 정보 생성자 입니다.
    SaleInfo(int number, double saleRate) {
        this.number = number;
        this.saleRate = saleRate;
    }

    //세일 정보를 출력하는 기능을 합니다.
    public static void printSaleInfo() {
        for(SaleInfo info : SaleInfo.values()){
            System.out.println(info.getNumber()+ ". " + info.name()+" : "+info.getSaleRate());
        }
    }

    //세일이 적용된 최종 값을 계산하고 출력해줍니다.
    public static Double resultTotal(int num, double total) {
        for(SaleInfo member : SaleInfo.values()) {
            if(member.getNumber() == num ) {
                return total - (total * (member.getSaleRate()/100));
            }
        }
        return 0.0;
    }

    //세일 정보에 해당하는 number를 반환합니다.
    public int getNumber() {
        return this.number;
    }
    //세일 정보에 해당하는 할인율을 반환합니다.
    public double getSaleRate() {
        return this.saleRate;
    }
}
