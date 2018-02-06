package com.edu.java.design.mode.aggregate;

/**
 * Created by garychen on 2018/2/6.
 */
public interface Aggregate {
    /**
     * 想要遍历集合中的元素,可以调用 iterator 方法来生成一个实现 Iterator 接口的类
     * @return
     */
    public abstract Iterator iterator();
}
