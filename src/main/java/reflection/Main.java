package reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface MyInterface {
    void method();
}


class MyInterfaceImpl implements MyInterface {
    @Override
    public void method() {
        System.out.println("This is method!");
    }
}


class ProxyClass implements InvocationHandler {

    Object obj;

    public ProxyClass(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;

        try {
            System.out.println("before the method is called ");
            result = method.invoke(obj, args);

        } catch (Exception ex){
        }finally {
            System.out.println("after the method is called");
        }
        return result;
    }
}


public class Main {
    public static void main(String[] args) {
        MyInterface myInterface = (MyInterface) Proxy.newProxyInstance(MyInterface.class.getClassLoader(), new Class[] {MyInterface.class},
                new ProxyClass(new MyInterfaceImpl()));
        myInterface.method();
    }
}
