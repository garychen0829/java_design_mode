package com.edu.java.base.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class MathProxy {
	//要道理的对象
	private IMath imath;

	public MathProxy(IMath imath) {
		this.imath = imath;
	}

	public IMath getLoggingProxy(){
		IMath proxy = null;

		//代理对象由那一个类加载器,负责加载
		ClassLoader loader = imath.getClass().getClassLoader();

		//代理对象的类型,即其中有那些方法
		Class[] interfaces = new Class[]{IMath.class};

		////当调用代理对象其中的方式时,该代码执行
		InvocationHandler h = new InvocationHandler() {
			/**
			 * proxy:正在返回的那个代理对象,在invoke方法中都不使用该对象
			 * method:正在被调用的方法
			 * args:调用方法时,传入的参数
			 */
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("invoke ...");
				String methodName = method.getName();
				//执行方法
				Object result = method.invoke(imath, args);
				System.out.println("methodName:"+methodName);
				return result;
			}
		};

		proxy = (IMath)Proxy.newProxyInstance(loader, interfaces, h);

		return proxy;
	}

}
