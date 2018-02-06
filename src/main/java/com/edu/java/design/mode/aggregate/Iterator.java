package com.edu.java.design.mode.aggregate;

/**
 * Created by garychen on 2018/2/6.
 */
public interface Iterator {
    //是否存在下一个元素
    public abstract boolean hasNext();
    //获取下一个元素的next方法
    public abstract Object next();
}
