package com.edu.java.design.mode.chainOfResponseibility;

/**
 * 创建扩展了该记录器类的实体类
 * Created by garychen on 2018/3/5.
 */
public class ConsoleLogger extends AbstractLogger{

    public ConsoleLogger(int level){
        this.level = level;
    }

    protected void write(String message) {
        System.out.println("ConsoleLogger Logger: " + message);
    }

}
