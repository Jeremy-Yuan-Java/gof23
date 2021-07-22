import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CJLIBDynamicProxyClient {
    public static void main(String[] args) {

        MyRunner some = new YaoMing();
        // 获取代理对象
        MyRunner proxy = new CJLIBProxyFactory(some).getProxy();
        proxy.run();

    }
}

interface MyRunner {
    public void run();
}

class YaoMing implements MyRunner {

    @Override
    public void run() {
        System.out.println("跑步");
    }


}

class CJLIBProxyFactory implements MethodInterceptor{
    public CJLIBProxyFactory(MyRunner target) {
        this.target = target;
    }

    private MyRunner target;

    public MyRunner getProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MyRunner.class);
        enhancer.setCallback(this);
        return (MyRunner) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("被增强了");
        return method.invoke(target, objects);
    }
}
