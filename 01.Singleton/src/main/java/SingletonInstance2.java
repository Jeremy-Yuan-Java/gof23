public class SingletonInstance2 {

    private static volatile SingletonInstance2 instance = null;

    private SingletonInstance2() {

    }

    public static synchronized SingletonInstance2 getInstance() {
        if (instance==null){
            instance= new SingletonInstance2();
        }
        return instance;

    }

}
