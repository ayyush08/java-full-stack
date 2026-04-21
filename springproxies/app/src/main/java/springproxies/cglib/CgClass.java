package springproxies.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CgClass {
    static class Original{
        public  void originalMethod(String s){
            System.out.println(s);
        }
    }

    static class Handler implements MethodInterceptor{
        private final Original original;

        public  Handler(Original original){
            this.original = original;
        }

        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("Before");
            method.invoke(original,objects);
            System.out.println("After");
            return methodProxy.invokeSuper(o,objects);
//            return  null;
        }

    }

    public static void main(String[] args) {
        try{
            Original original = new Original();
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Original.class);
            enhancer.setCallback(new Handler(original));


            Original proxy = (Original)enhancer.create();
            proxy.originalMethod("CGLIB says Hello");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
