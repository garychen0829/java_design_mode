package com.edu.java.design.mode.strategy;

import com.edu.java.design.mode.strategy.impl.AddStrategy;
import com.edu.java.design.mode.strategy.impl.DivStrategy;
import com.edu.java.design.mode.strategy.impl.MulStrategy;
import com.edu.java.design.mode.strategy.impl.SubStrategy;

/**
 * Created by garychen on 2018/4/9.
 */
public class TestMain {
    public static void main(String[] args) {
        int n = 8;
        int m = 4;

        int result = 0;
        //IStrategy addStrategy = new AddStrategy();
        StrategyContext context = new StrategyContext(new AddStrategy());
        result = context.execute(n,m);
        System.out.println("result add: " + result);

//        IStrategy subStrategy = new SubStrategy();
        context = new StrategyContext(new SubStrategy());
        result = context.execute(n,m);
        System.out.println("result sub: " + result);

//        IStrategy mulStrategy = new MulStrategy();
        context = new StrategyContext(new MulStrategy());
        result = context.execute(n,m);
        System.out.println("result mul: " + result);

//        IStrategy divStrategy = new DivStrategy();
        context = new StrategyContext(new DivStrategy());
        result = context.execute(n,m);
        System.out.println("result div: " + result);
    }
}
