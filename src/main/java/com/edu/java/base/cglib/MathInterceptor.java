//package com.edu.java.base.cglib;
//
//import java.lang.reflect.Method;
//import java.util.Arrays;
//
//import org.springframework.cglib.proxy.MethodInterceptor;
//import org.springframework.cglib.proxy.MethodProxy;
//
//public class MathInterceptor implements MethodInterceptor{
//
//	/**
//	 * 定义一个拦截器。
//	 * 在调用目标方法时，CGLib会回调MethodInterceptor接口方法拦截，
//	 * 来实现你自己的代理逻辑，类似于JDK中的InvocationHandler接口
//	 *
//	 * Object obj:为由CGLib动态生成的代理类实例
//	 * Method method:为上文中实体类所调用的被代理的方法引用
//	 * Object[] args:为参数值列表
//	 * MethodProxy proxy:为生成的代理类对方法的代理引用
//	 */
//	@Override
//	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
//		//调用代理类实例上的proxy方法的父类方法（即实体类中对应的方法）
//		Object result = null;
//		try {
//			System.out.println("Method:"+method.getName()+"()"+"...Params:"+Arrays.asList(args));
//			result = proxy.invokeSuper(obj, args);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("result : "+result);
//		//从代理实例的方法调用返回的值
//		return result;
//	}
//
//}
