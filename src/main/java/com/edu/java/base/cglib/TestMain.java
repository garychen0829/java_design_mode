//package com.edu.java.base.cglib;
//
//import org.springframework.cglib.proxy.Enhancer;
//
//import java.lang.*;
//
//public class TestMain {
//
//	public static void main(String[] args) {
//		//Enhancer类是CGLib中的一个字节码增强器
//		Enhancer enhancer = new Enhancer();
//		//将被代理类设置成父类
//		enhancer.setSuperclass(Math.class);
//		//设置拦截器
//		enhancer.setCallback(new MathInterceptor());
//		/**
//		 * 最后执行enhancer.create()动态生成一个代理类,
//		 * 并从Object强制转型成父类型
//		 */
//		Math ccni = (Math)enhancer.create();
//
//		int result = ccni.add(2, 5);
//		result = ccni.sub(9, 7);
//	}
//}
//
