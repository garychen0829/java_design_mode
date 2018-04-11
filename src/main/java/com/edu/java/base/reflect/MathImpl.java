package com.edu.java.base.reflect;

public class MathImpl implements IMath{

	public int mul(int i, int j) {
		int result = i * j;
		return result;
	}

	public int did(int i, int j) {
		int result = i / j;
		return result;
	}

}
