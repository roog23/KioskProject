package Challenge.Lv2;

public enum SaleInfo {
    국가유공자(1,10),
    군인(2,5),
    학생(3,3),
    일반(4,0);

    private final int number;
    private final double saleRate;

    SaleInfo(int number, double saleRate) {
        this.number = number;
        this.saleRate = saleRate;
    }

    public static void printSaleInfo() {
        for(SaleInfo info : SaleInfo.values()){
            System.out.println(info.getNumber()+ ". " + info.name()+" : "+info.getSaleRate());
        }
    }

    public static Double resultTotal(int num, double total) {
        for(SaleInfo member : SaleInfo.values()) {
            if(member.getNumber() == num ) {
                return total - (total * (member.getSaleRate()/100));
            }
        }
        return 0.0;
    }

    public int getNumber() {
        return this.number;
    }
    public double getSaleRate() {
        return this.saleRate;
    }
}
