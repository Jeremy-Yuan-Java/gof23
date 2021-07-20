public class SingletonInstance3 {

    // 分配内存空间,初始化对象,将对象指向刚分配的内存空间;
    // 分配内存空间,将对象指向刚分配的内存空间,初始化对象
    // 由于jvm存在乱序执行功能，所以可能在2还没执行时就先执行了3，如果此时再被切换到线程B上，由于执行了3，INSTANCE 已经非空了，会被直接拿出来用，这样的话，就会出现异常。这个就是著名的DCL失效问题。
    // 不过在JDK1.5之后，官方也发现了这个问题，故而具体化了volatile，
    // 即在JDK1.6及以后，只要定义为private volatile static SingleTon  INSTANCE = null;就可解决DCL失效问题。volatile确保INSTANCE每次均在主内存中读取，这样虽然会牺牲一点效率，但也无伤大雅。
    // 避免这样增加关键字volatile
    // 作者你好 我认为volatile 此处生效的原因 并不是 变量每次都从主存中获取最新变量,因为变量地址已经固定了 再怎么从主存中获取不都是null 原因应该是 volatile 的内存栅栏 功能 告知编译器的在标记的变量前后不使用优化功能 就是说 1.在堆内存开辟内存空间。 2.在堆内存中实例化SingleTon里面的各个参数。 3.把对象指向堆内存空间。 1,2,3 步不会乱序优化 ,所以才避免DCL 失效
    private static SingletonInstance3 instance = null;

    private SingletonInstance3() {

    }

    public static  SingletonInstance3 getInstance() {
        if(instance==null){
            SingletonInstance3 singletonInstance3=null;
            synchronized (SingletonInstance3.class){
                singletonInstance3 =instance;
                if (singletonInstance3==null){
                    synchronized (SingletonInstance3.class){
                        if (singletonInstance3==null){
                            singletonInstance3=new SingletonInstance3();
                        }
                    }
                }
                instance=singletonInstance3;
            }
        }
        return instance;
    }


    public static  SingletonInstance3 getInstance2() {
        if(instance==null){
                if (instance==null){
                    synchronized (SingletonInstance3.class){
                        if (instance==null){
                            instance=new SingletonInstance3();
                        }
                    }
                }
            }
        return instance;
    }

}
