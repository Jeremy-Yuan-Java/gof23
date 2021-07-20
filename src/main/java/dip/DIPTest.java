package dip;

//依赖倒置原则的主要作用如下。
//        依赖倒置原则可以降低类间的耦合性。
//        依赖倒置原则可以提高系统的稳定性。
//        依赖倒置原则可以减少并行开发引起的风险。
//        依赖倒置原则可以提高代码的可读性和可维护性。
public class DIPTest {
    public static void main(String[] args) {
        Customer wang = new Customer();
        System.out.println("顾客购买以下商品：");
        wang.shopping(new ShaoguanShop());
        wang.shopping(new WuyuanShop());
    }
}

//商店
interface Shop {
    public String sell(); //卖
}

//韶关网店
class ShaoguanShop implements Shop {
    public String sell() {
        return "韶关土特产：香菇、木耳……";
    }
}

//婺源网店
class WuyuanShop implements Shop {
    public String sell() {
        return "婺源土特产：绿茶、酒糟鱼……";
    }
}

//顾客
class Customer {
    public void shopping(Shop shop) {
        //购物
        System.out.println(shop.sell());
    }
}