/**
 * 工厂方法
 */
public class FactoryMethodClient {
    public static void main(String[] args) {
        AbstractFactory haierFactory = new HaierFactory();
        haierFactory.productAir().show();
    }
}

interface AbstractFactory {
    public Air productAir();
}

class HaierFactory implements AbstractFactory {

    @Override
    public Air productAir() {
        return new HaierAir();
    }
}

class MediaFactory implements AbstractFactory {

    @Override
    public Air productAir() {
        return new MedeaAir();
    }
}

interface Air {
    public void show();
}

class HaierAir implements Air {

    @Override
    public void show() {
        System.out.println("海尔空调已生产");
    }
}

class MedeaAir implements Air {
    @Override
    public void show() {
        System.out.println("美的空调已生产");
    }
}