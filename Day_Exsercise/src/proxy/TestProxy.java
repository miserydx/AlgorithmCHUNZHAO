package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy {

    public static void main(String[] args){
        Service realService = new RealService();
        Service service = (Service) Proxy.newProxyInstance(Service.class.getClassLoader(), new Class[]{Service.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                switch (method.getName()){
//                    case "jumpToPage":
//                        System.out.println("dynamic jumpToPage");
//                        break;
//                    case "getData":
//                        System.out.println("dynamic getData");
//                        return "sa";
//                }
                return method.invoke(realService, args);
            }
        });
        service.jumpToPage();
        System.out.println("getData = "+service.getData(1));
        System.out.println("getNum = "+service.getNum());
    }

}
