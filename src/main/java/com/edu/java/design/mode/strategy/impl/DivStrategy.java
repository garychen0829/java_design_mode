package com.edu.java.design.mode.strategy.impl;

import com.edu.java.design.mode.strategy.IStrategy;

/**
 * Created by garychen on 2018/4/9.
 */
public class DivStrategy implements IStrategy {
    @Override
    public int execute(int n, int m) {
        System.out.println( n + " / " + m + " = " + (n / m));
        return n / m;
    }
}
