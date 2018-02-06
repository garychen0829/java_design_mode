package com.edu.java.design.mode.aggregate;

/**
 * Created by garychen on 2018/2/6.
 */
public class BookShelfIterator implements Iterator {
    private BookShelf bookShelf;
    private int index;
    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    public boolean hasNext(){
        if (index < bookShelf.getLength()) {
            return true;
        }else {
            return false;
        }
    }
    public Object next(){
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}
