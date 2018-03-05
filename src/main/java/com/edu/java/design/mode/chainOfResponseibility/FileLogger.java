package com.edu.java.design.mode.chainOfResponseibility;

/**
 * Created by garychen on 2018/3/5.
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("FileLogger Logger: " + message);
    }
}
