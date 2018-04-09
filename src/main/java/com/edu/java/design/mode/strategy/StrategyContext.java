package com.edu.java.design.mode.strategy;

/**
 * Created by garychen on 2018/4/9.
 */
public class StrategyContext {
    private IStrategy iStrategy;

    public StrategyContext(IStrategy iStrategy) {
        this.iStrategy = iStrategy;
    }

    public int execute(int n, int m){
        return iStrategy.execute(n,m);
    }
}
