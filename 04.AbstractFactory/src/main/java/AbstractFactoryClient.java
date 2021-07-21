public class AbstractFactoryClient {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new NewFactory();
        abstractFactory.getCar().run();
        abstractFactory.getColor().run();
    }
}

interface AbstractFactory {
    Car getCar();

    Color getColor();
}


class NewFactory implements AbstractFactory {

    @Override
    public Car getCar() {
        return new NewCar();
    }

    @Override
    public Color getColor() {
        return new Blue();
    }
}


class OldFactory implements AbstractFactory {

    @Override
    public Car getCar() {
        return new OldCar();
    }

    @Override
    public Color getColor() {
        return new Red();
    }
}


interface Color {
    void run();
}

class Red implements Color {

    @Override
    public void run() {
        System.out.println("生成红色");
    }
}

class Blue implements Color {

    @Override
    public void run() {
        System.out.println("生成蓝色");
    }
}


interface Car {
    void run();
}

class NewCar implements Car {

    @Override
    public void run() {
        System.out.println("新车");
    }
}


class OldCar implements Car {

    @Override
    public void run() {
        System.out.println("旧车");
    }
}