package com.edu.java.design.mode.aggregate.main;

import com.edu.java.design.mode.aggregate.Book;
import com.edu.java.design.mode.aggregate.BookShelf;
import com.edu.java.design.mode.aggregate.Iterator;
import org.junit.Test;

/**
 * Created by garychen on 2018/2/6.
 */
public class Main {

    /**
     * 迭代器模式测试方法入口
     */
    @Test
    public void test_Aggregate(){
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("三国演义"));
        bookShelf.appendBook(new Book("水浒传"));
        bookShelf.appendBook(new Book("红楼梦"));
        bookShelf.appendBook(new Book("西游记"));

        Iterator it = bookShelf.iterator();
        while (it.hasNext()){
            Book book = (Book) it.next();
            System.out.println(book.getName());
        }
    }

}
