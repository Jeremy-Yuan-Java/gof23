import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestSingleton {

    public static void main(String[] args) {

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 100, 1, TimeUnit.MINUTES, new SynchronousQueue<Runnable>());


        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            integerArrayList.add(i);
        }

        for (Integer s:
        integerArrayList) {
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < s; i++) {
                        SingletonInstance2 instance2 = SingletonInstance2.getInstance();
                        System.out.println(instance2);
                    }
                }
            });
        }


    }
}
