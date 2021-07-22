public class StaticProxyClient {


    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.sellHenan();
    }
}

interface SellTickets {
    void sellHenan();
    void sellHuber();
}

class TrainsStation implements SellTickets{

    @Override
    public void sellHenan() {
       System.out.println("河南的票");
    }

    @Override
    public void sellHuber() {
        System.out.println("湖北的票");
    }
}

class Proxy implements SellTickets{

    private TrainsStation sellTickets =new TrainsStation();


    @Override
    public void sellHenan() {
        System.out.println("河南老乡加油");
        sellTickets.sellHenan();
    }

    @Override
    public void sellHuber() {
        System.out.println("正常售票，收点钱");
        sellTickets.sellHuber();
    }
}