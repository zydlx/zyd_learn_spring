package com.zyd.learn.spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 赵育冬
 */
public class JavaProxyTest {
    public static void main(String[] args) {
        final UserServiceImpl userServiceImpl = new UserServiceImpl();

        UserService server = (UserService) Proxy.newProxyInstance(JavaProxyTest.class.getClassLoader(), new Class[]{UserService.class}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("前置通知");
                method.invoke(userServiceImpl,args);
                System.out.println("后置通知");
                return null;
            }
        });
        String name = server.getName();

    }
}
