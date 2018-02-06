package com.edu.java.design.mode.aggregate;

/**
 * 书类
 * Created by garychen on 2018/2/6.
 */
public class Book {
    //书名
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
