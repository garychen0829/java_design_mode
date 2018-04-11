package com.edu.java.base.reflect;


public class Main {

	public static void main(String[] args) {
		IMath im = new MathImpl();
		//new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
		IMath proxy = new MathProxy(im).getLoggingProxy();
		int i = 4;
		int j = 5;
		
		int result = im.did(i, j);
		System.out.println(">>>>>>>>>>>>>>>"+result);
		result = proxy.mul(i, j);
		System.out.println("");
	}
}
