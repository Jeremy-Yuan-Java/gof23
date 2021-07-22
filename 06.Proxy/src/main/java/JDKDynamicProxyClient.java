import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKDynamicProxyClient {
    public static void main(String[] args) {

//使用Proxy获取代理对象
/* newProxyInstance()方法参数说明： ClassLoader loader ：
 类加载器，用于加载代理类，使用真实对象的类加载 器即可
 Class<?>[] interfaces ：真实对象所实现的接口，代理模式真实对象和代 理对象实现相同的接口
 InvocationHandler h ： 代理对象的调用处理程序 */
        Star star = new LiuDeHua();

        Star proxyInstance = (Star) Proxy.newProxyInstance(star.getClass().getClassLoader(), star.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println("我加强了");
                return method.invoke(star, args);
            }
        });
        proxyInstance.dance();
        proxyInstance.sing();


    }
}

interface Star {
    String sing();

    String dance();
}

class LiuDeHua implements Star {

    @Override
    public String sing() {
        System.out.println("唱歌");
        return "TEST";
    }

    @Override
    public String dance() {
        System.out.println("跳舞");
        return "TEST";
    }
}
