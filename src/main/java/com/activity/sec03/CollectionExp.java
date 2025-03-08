package com.activity.sec03;


import com.models.sec03.book;
import com.models.sec03.library;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CollectionExp {
    private static final Logger log = LoggerFactory.getLogger(CollectionExp.class);

    public static void main(String args[]) {
        book bk1 = book.newBuilder().setAuthor("A").setName("A book").build();
        book bk2 = book.newBuilder().setAuthor("B").setName("B book").build();
        library lib = library.newBuilder().setName("Lib").addBook(bk1).addBook(bk2).build();
        log.info("{}", lib);
    }
}
