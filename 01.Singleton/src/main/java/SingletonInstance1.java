public class SingletonInstance1 {

    private static SingletonInstance1 instance = new SingletonInstance1();

    private SingletonInstance1() {

    }

    public static SingletonInstance1 getInstance() {
        return instance;
    }

}
