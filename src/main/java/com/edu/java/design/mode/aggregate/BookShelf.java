package com.edu.java.design.mode.aggregate;

/**
 * 书架<br>
 * 书架上有很多书
 * Created by garychen on 2018/2/6.
 */
public class BookShelf implements Aggregate {
    private Book[] books;
    private int last = 0;

    public BookShelf(int maxsize) {
        this.books = new Book[maxsize];
    }

    public Book getBookAt(int index){
        return books[index];
    }

    public void appendBook(Book book){
        this.books[last] = book;
        last++;
    }
    public int getLength(){
        return last;
    }

    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
