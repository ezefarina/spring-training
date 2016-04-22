package org.ezefarina.spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PruebaProxy {

  public interface IObject {
    String hola(String param);
  }

  public static class ObjectImpl implements IObject {
    public String hola(String param) {
      return param;
    }
  }

  public static void main (String args[]) {
    final IObject objetoOriginal = new ObjectImpl();
    IObject objetoProxy = (IObject) Proxy.newProxyInstance(
        objetoOriginal.getClass().getClassLoader(),
        new Class[] {IObject.class},
        new InvocationHandler() {
          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result = method.invoke(objetoOriginal,args);
            System.out.println(result);
            return result;
          }
        });
    objetoProxy.hola("sino");
  }

}
